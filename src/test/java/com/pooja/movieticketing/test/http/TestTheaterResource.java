package com.pooja.movieticketing.test.http;

import java.util.List;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pooja.movieticketing.http.HttpError;
import com.pooja.movieticketing.http.HttpTheater;
/**
 * Test error scenarios using a Client
 * @author pooja
 *
 */
public class TestTheaterResource {
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "pooja-movieticketing/rest/theater";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

	@Test
	public void testGetTheatersNoParamsJson(){						
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();

		//you can use this to print the response
		System.out.println("HTTP Status=" + response.getStatus());
		//NOTE - you can read the entity ONLY once
		System.out.println(response.readEntity(String.class));
				
		verifyMissing(response);
	}
	
	@Test
	public void testGetTheatersNoParamsXml(){						
		Response response =	target.request().accept(MediaType.APPLICATION_XML).get();		
		verifyMissing(response);
	}

	private void verifyMissing(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("MISSING_DATA", error.code);
		Assert.assertEquals("no search parameter provided", error.message);
		Assert.assertEquals("", error.debug);		
	}
	
	@Test
	public void testCreateTheatersNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<theater/>", MediaType.APPLICATION_XML));		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateTheatersNoParamsEntityXml(){					
		HttpTheater theaterToSend = new HttpTheater();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(theaterToSend, MediaType.APPLICATION_XML));	
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateTheatersNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{theater:{}}", MediaType.APPLICATION_JSON));		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateTheatersNoParamsEntityJson(){					
		HttpTheater theaterToSend = new HttpTheater();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));		
		verifyInvalid(response);
	}

	private void verifyInvalid(Response response) {
		HttpError error = response.readEntity(HttpError.class);
		Assert.assertEquals(409, response.getStatus());
		Assert.assertEquals(409, error.status);
		Assert.assertEquals("INVALID_FIELD", error.code);
		Assert.assertEquals("password is required", error.message);
		Assert.assertEquals("", error.debug);		
	}
	
	@Test
	public void testCreateAndGetTheater(){					
		HttpTheater theaterToSend = new HttpTheater();
		theaterToSend.theaterName="foo"+new Random().nextInt(99999);
		theaterToSend.address="bar"+new Random().nextInt(99999);;
		theaterToSend.screens=3;
		theaterToSend.zip=94086;
		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theaterToSend, MediaType.APPLICATION_JSON));
		
		HttpTheater createResponse = response.readEntity(HttpTheater.class);
		//System.err.println(createResponse);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.theaterName, theaterToSend.theaterName);
		Assert.assertEquals(createResponse.address, theaterToSend.address);
		Assert.assertEquals(createResponse.screens, theaterToSend.screens);
		Assert.assertEquals(createResponse.zip, theaterToSend.zip);
		Assert.assertNotNull(createResponse.id);
		
		//search for just created theater		
		Response search = target.queryParam("theaterName", theaterToSend.theaterName).queryParam("address", theaterToSend.address).queryParam("screens", theaterToSend.screens).queryParam("zip", theaterToSend.zip).request().accept(MediaType.APPLICATION_JSON).get();
		List<HttpTheater> searchResponse = search.readEntity(new GenericType<List<HttpTheater>>(){});
		Assert.assertEquals(searchResponse.get(0), createResponse);		
	}
}
