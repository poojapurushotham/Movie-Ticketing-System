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

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.impl.MovieImpl;
import com.pooja.movieticketing.http.entity.HttpMovie;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.exception.MovieTicketingException;

@Path("/movie")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieService movieService;
	
	@POST
	@Path("/")
	
	public Response createMovie(HttpMovie newMovie){
		Movie movieToCreate = convert(newMovie);
		Movie addedMovie = movieService.addMovie(movieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movie/"+addedMovie.getMovieId()).entity(new HttpMovie(addedMovie)).build();
	}	

	@GET
	@Path("/{movieId}")	
	public HttpMovie getMovieById(@PathParam("movieId") int movieId){
		logger.info("getting Movie by id:" + movieId);
		Movie customer = movieService.getMovie(movieId);	
		return new HttpMovie(customer);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="movie")
	public List<HttpMovie> getMovieSearch(@QueryParam("movieName") String movieName) throws MovieTicketingException{
		List<Movie> found = movieService.getMovie(movieName);
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for(Movie movie:found){
			returnList.add(new HttpMovie(movie));
		}
		return returnList;
	}
	
	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.movieName);
		movie.setLanguage(httpMovie.language);
		movie.setGenre(httpMovie.genre);
		movie.setRating(httpMovie.rating);
		return movie;
	}	
}
