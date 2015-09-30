package com.pooja.movieticketing.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.TheaterImpl;
import com.pooja.movieticketing.http.entity.HttpTheater;
import com.pooja.movieticketing.service.TheaterService;
import com.pooja.movieticketing.service.exception.MovieTicketingException;

@Path("/theater")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheaterResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterService theaterService;
	
	@POST
	@Path("/")
	
	public Response createTheater(HttpTheater newTheater){
		Theater theaterToCreate = convert(newTheater);
		Theater addedTheater = theaterService.addTheater(theaterToCreate);
		return Response.status(Status.CREATED).header("Location", "/theater/"+addedTheater.getTheaterId()).entity(new HttpTheater(addedTheater)).build();
	}	

	@GET
	@Path("/{theaterId}")	
	public HttpTheater getTheaterById(@PathParam("theaterId") int theaterId){
		logger.info("getting Theater by id:" + theaterId);
		Theater theater = theaterService.getTheater(theaterId);	
		return new HttpTheater(theater);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="theater")
	public List<HttpTheater> getTheaterSearch(@QueryParam("zip") long zip) throws MovieTicketingException{
		List<Theater> found = theaterService.getTheater(zip);
		List<HttpTheater> returnList = new ArrayList<>(found.size());
		for(Theater theater:found){
			returnList.add(new HttpTheater(theater));
		}
		return returnList;
	}
	
	private Theater convert(HttpTheater httpTheater) {
		TheaterImpl theater = new TheaterImpl();
		theater.setTheaterName(httpTheater.theaterName);
		theater.setScreens(httpTheater.screens);
		theater.setAddress(httpTheater.address);
		return theater;
	}	
}
