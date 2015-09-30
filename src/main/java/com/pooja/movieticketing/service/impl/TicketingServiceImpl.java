package com.pooja.movieticketing.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Ticket;
import com.pooja.movieticketing.entity.impl.TicketImpl;
import com.pooja.movieticketing.repository.CustomerAccountRepository;
import com.pooja.movieticketing.repository.TicketRepository;
import com.pooja.movieticketing.service.TicketingService;

@Service
public class TicketingServiceImpl implements TicketingService{
	
	@Autowired
	private TicketRepository ticketingRepository;
	
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	@Transactional
	@Override
	public Ticket buyTicket(Showtime show, String movieName, String theaterName, String custType, int seatNum, double discount) {
		Ticket ticket = new TicketImpl();
		if(reserveSeat(show.getScreen(), seatNum)) {
			ticket.setSeatNum(seatNum);
			ticket.setDiscount(discount);
			if(show.getMovie().getMovieName().equals(movieName)) {
				ticket.setMovieName(movieName);
			}
			if(show.getTheater().getTheaterName().equals(theaterName)) {
				ticket.setTheaterName(theaterName);
				ticket.setScreenName(show.getScreen().getScreenName());
			}
			ticket.setCutomerType(custType);
			ticket.setPrice(calculateTotal(custType));
		}
		return ticket;
	}


	private double calculateTotal(String custType) {	
		double price = 12; //default ticket price
		if (("a").equalsIgnoreCase(custType)) {
			price=12;
		} else if(("c").equalsIgnoreCase(custType)) {
			price=6;
		} else if(("s").equalsIgnoreCase(custType)) {
			price=10;
		}
		return price;
	}

	private boolean reserveSeat(Screen screen, int seatNum) {
		screen.getSeats();
		screen.getReserved();
		if(screen.getReserved().contains(seatNum)) {
			//This seat is already reserved by someone
			return false;
		} else {
			//System.out.println("Seat is reserved for you!\n");
			screen.setReserved(seatNum);
		}	
		return true;		
	}
	

	@Transactional
	@Override
	public List<Ticket> viewBookingHistory(int accountId) {
		Account account = customerAccountRepository.getAccount(accountId);
		if(account==null) {
			throw new IllegalArgumentException("Invalid account Id");
		}
		return ticketingRepository.getTicketsPurchasedByAccount(accountId);
	}

}
