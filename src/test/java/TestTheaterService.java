import junit.framework.Assert;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.TheaterImpl;
import com.pooja.movieticketing.repository.TheaterRepository;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestTheaterService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private TheaterRepository theaterRepository; 

	@SuppressWarnings("deprecation")
	@Test
	public void addAndGetTheaters(){
		Theater theater = new TheaterImpl();
		theater.setTheaterName("Centuary"+new Random().nextInt(99999));
		theater.setScreens(3);
		theater.setZip(94086);
		
		int theaterId = theaterRepository.addTheater(theater);
		System.out.println("added id "+ theaterId);
		Assert.assertNotSame(0, theaterId);		
		
		Theater found = theaterRepository.getTheater(theaterId);
		Assert.assertEquals(found.getTheaterId(), theaterId);
		Assert.assertEquals(found.getTheaterName(), theater.getTheaterName());
		Assert.assertEquals(found.getScreens(), theater.getScreens());
		Assert.assertEquals(found.getZip(), theater.getZip());
	}
}


