import junit.framework.Assert;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Ticket;
import com.pooja.movieticketing.entity.impl.MovieImpl;
import com.pooja.movieticketing.entity.impl.TicketImpl;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.service.MovieService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestMovieService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private MovieRepository movieRepository; 
	
	@Autowired
	private MovieService movieService;

	@SuppressWarnings("deprecation")
	@Test
	public void addAndGetMovies(){
		Movie movie = new MovieImpl();
		movie.setMovieName("Titanic"+new Random().nextInt(99999));
		movie.setLanguage("English");
		movie.setGenre("Romantic");
		movie.setRating(5);
		
		int movieId = movieRepository.addMovie(movie);
		System.out.println("added id "+ movieId);
		Assert.assertNotSame(0, movieId);		
		
		Movie found = movieRepository.getMovie(movieId);
		Assert.assertEquals(found.getMovieId(), movieId);
		Assert.assertEquals(found.getMovieName(), movie.getMovieName());
		Assert.assertEquals(found.getLanguage(), movie.getLanguage());
		Assert.assertEquals(found.getGenre(), movie.getGenre());
		Assert.assertEquals(found.getRating(), movie.getRating());
	}
	
	
}