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
import com.pooja.movieticketing.http.HttpCustomer;
/**
 * Test error scenarios using a Client
 * @author pooja
 *
 */
public class TestCustomerResource {
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "pooja-movieticketing/rest/customer";
	
	private Client client = ClientBuilder.newClient();
	private WebTarget target;
	
	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

	@Test
	public void testGetCustomersNoParamsJson(){						
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();

		//you can use this to print the response
		System.out.println("HTTP Status=" + response.getStatus());
		//NOTE - you can read the entity ONLY once
		System.out.println(response.readEntity(String.class));
				
		verifyMissing(response);
	}
	
	@Test
	public void testGetCustomersNoParamsXml(){						
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
	public void testCreateCustomersNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<customer/>", MediaType.APPLICATION_XML));		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateCustomersNoParamsEntityXml(){					
		HttpCustomer customerToSend = new HttpCustomer();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(customerToSend, MediaType.APPLICATION_XML));	
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateCustomersNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{customer:{}}", MediaType.APPLICATION_JSON));		
		verifyInvalid(response);
	}
	
	@Test
	public void testCreateCustomersNoParamsEntityJson(){					
		HttpCustomer customerToSend = new HttpCustomer();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(customerToSend, MediaType.APPLICATION_JSON));		
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
	public void testCreateAndGetCustomer(){					
		HttpCustomer customerToSend = new HttpCustomer();
		customerToSend.username="foo"+new Random().nextInt(99999);
		customerToSend.emailId="bar"+new Random().nextInt(99999);;
		customerToSend.password="12345";
		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(customerToSend, MediaType.APPLICATION_JSON));
		
		HttpCustomer createResponse = response.readEntity(HttpCustomer.class);
		//System.err.println(createResponse);
		Assert.assertEquals(201, response.getStatus());
		Assert.assertEquals(createResponse.username, customerToSend.username);
		Assert.assertEquals(createResponse.emailId, customerToSend.emailId);
		Assert.assertNotNull(createResponse.id);
		Assert.assertNull(createResponse.password);
		
		//search for just created user		
		Response search = target.queryParam("username", customerToSend.username).queryParam("emailId", customerToSend.emailId).request().accept(MediaType.APPLICATION_JSON).get();
		List<HttpCustomer> searchResponse = search.readEntity(new GenericType<List<HttpCustomer>>(){});
		Assert.assertEquals(searchResponse.get(0), createResponse);		
	}
}
