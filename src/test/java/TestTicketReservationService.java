import junit.framework.Assert;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.pooja.movieticketing.entity.Ticket;
import com.pooja.movieticketing.entity.impl.TicketImpl;
import com.pooja.movieticketing.repository.TicketRepository;
import com.pooja.movieticketing.service.CustomerAccountService;
import com.pooja.movieticketing.service.TicketingService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestTicketReservationService extends AbstractJUnit4SpringContextTests  {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TicketingService ticketingService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void addAndGetTickets(){
		Ticket ticket = new TicketImpl();
		ticket.setMovieName("Titanic"+new Random().nextInt(99999));
		ticket.setScreenName("Screen3");
		ticket.setTheaterName("Centuary");
		ticket.setSeatNum(5);
		ticket.setDiscount(0);
		ticket.setCutomerType("a");
		ticket.setAccountId(1);
		
		int ticketId = ticketRepository.addTicket(ticket);
		System.out.println("added id "+ ticketId);
		Assert.assertNotSame(0, ticketId);		
		
		Ticket found = ticketRepository.getTicket(ticketId);
		Assert.assertEquals(found.getTicketId(), ticketId);
		Assert.assertEquals(found.getMovieName(), ticket.getMovieName());
		Assert.assertEquals(found.getScreenName(), ticket.getScreenName());
		Assert.assertEquals(found.getSeatNum(), ticket.getSeatNum());
		Assert.assertEquals(found.getDiscount(), ticket.getDiscount());
		Assert.assertEquals(found.getCutomerType(), ticket.getCutomerType());
		Assert.assertEquals(found.getAccountId(), ticket.getAccountId());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testTicketBookingHistory(){
		Ticket ticket = new TicketImpl();
		ticket.setMovieName("Titanic"+new Random().nextInt(99999));
		ticket.setScreenName("Screen3");
		ticket.setTheaterName("Centuary");
		ticket.setSeatNum(5);
		ticket.setDiscount(0);
		ticket.setCutomerType("a");
		ticket.setAccountId(1);
		
		int ticketId = ticketRepository.addTicket(ticket);
		System.out.println("added id "+ ticketId);
		
		List<Ticket> tickets = ticketingService.viewBookingHistory(1);
		Assert.assertNotNull(tickets);
		Assert.assertTrue(tickets.toString().contains("[Titanic, Screen3, Centuary, 5, 0, a, 1]")); 
	}
	
}


