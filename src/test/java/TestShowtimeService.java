import junit.framework.Assert;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.MovieImpl;
import com.pooja.movieticketing.entity.impl.ScreenImpl;
import com.pooja.movieticketing.entity.impl.ShowtimeImpl;
import com.pooja.movieticketing.entity.impl.TheaterImpl;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.ScreenRepository;
import com.pooja.movieticketing.repository.ShowtimeRepository;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.CustomerAccountService;
import com.pooja.movieticketing.util.DateUtil;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestShowtimeService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private ShowtimeRepository showtimeRepository; 
	
	@Autowired
	private MovieRepository movieRepository; 
	
	@Autowired
	private TheaterRepository theaterRepository; 
	
	@Autowired
	private ScreenRepository screenRepository; 

	@SuppressWarnings("deprecation")
	@Test
	public void TestShowtimes(){
		//movie
		Movie movie = new MovieImpl();
		movie.setMovieName("Mummy"+new Random().nextInt(99999));
		movie.setLanguage("English");
		movie.setGenre("Fiction");
		movie.setRating(5);
		
		int movieId = movieRepository.addMovie(movie);
		System.out.println("added id "+ movieId);
		Assert.assertNotSame(0, movieId);		
		
		//theater
		Theater theater = new TheaterImpl();
		theater.setTheaterName("Centuary"+new Random().nextInt(99999));
		theater.setScreens(3);
		theater.setZip(94086);
		
		int theaterId = theaterRepository.addTheater(theater);
		System.out.println("added id "+ theaterId);
		Assert.assertNotSame(0, theaterId);		
		
		//screen
		Screen screen = new ScreenImpl();
		screen.setScreenName("Screen3");
		screen.setSeats(100);
		
		int screenId = screenRepository.addScreen(screen);
		System.out.println("added id "+ screenId);
		Assert.assertNotSame(0, screenId);		
		
		List<Showtime> showtimes = showtimeRepository.getShowtimes(movie.getMovieId(), theater.getTheaterId(), screen.getScreenId());
		//yyyy/MM/dd hh:mm:ss
		Showtime showtime = new ShowtimeImpl();
		showtime = showtimes.get(0);
		showtime.setMovieScreenTime(DateUtil.getDate("2015/10/20 11:00:00"));
		//update with new showtimings
		showtimeRepository.updateShowtime(showtime);
		
		
		showtimes = showtimeRepository.getShowtimes(movie.getMovieId(), theater.getTheaterId(), screen.getScreenId());
		showtime = showtimes.get(0);
		Assert.assertNotNull(showtimes);
		Assert.assertTrue(showtime.toString().contains("[Mummy Centuary Screen3 2015/10/20 11:00:00]")); 
		
	
		List<Theater> theaters = showtimeRepository.viewAllTheatersforMovie(movieId);
		Assert.assertNotNull(showtimes);
		Assert.assertTrue(showtime.toString().contains("[Centuary]")); 
		

		List<Movie> movies = showtimeRepository.viewAllMoviesInTheater(theaterId);
		Assert.assertNotNull(movies);
		Assert.assertTrue(movies.toString().contains("[Mummy]")); 
		
	}
	
}


