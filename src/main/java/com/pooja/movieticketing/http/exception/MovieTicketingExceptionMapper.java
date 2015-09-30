package com.pooja.movieticketing.http.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;


import com.pooja.movieticketing.service.exception.MovieTicketingException;

/**
 * Return HTTP 409 with response body 
 * 
 * @author pooja
 *
 */
@Provider
@Component
public class MovieTicketingExceptionMapper implements ExceptionMapper<MovieTicketingException>{

	@Override
	public Response toResponse(MovieTicketingException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}

}
