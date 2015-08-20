package com.pooja.movieticketing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.enitity.Ticket;
import com.pooja.movieticketing.enitity.impl.AccountImpl;
import com.pooja.movieticketing.enitity.impl.ScreenImpl;
import com.pooja.movieticketing.enitity.impl.TicketImpl;
import com.pooja.movieticketing.service.CustomerAccountService;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;
import com.pooja.movieticketing.service.TicketingService;

@Service
public class TicketingServiceImpl implements TicketingService{
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CustomerAccountService customerAccountService;
	
	public TicketImpl getTicket(String ticketId) {
		return new TicketImpl(ticketId);
	}
	
	public ScreenImpl getScreen(String screenName) {
		return new ScreenImpl(screenName);
	}
	
	
	public TicketImpl buyTicket(String screenName, String movieName, String theaterName, double discount) {
		// TODO Auto-generated method stub
		TicketImpl ticket = getTicket("A000");
		List<String> seats = reserveSeats(getScreen("screenName"));
		ticket.setSeatNum(seats);
		ticket.setDiscount(discount);
		ticket.setMovieName(movieName);
		ticket.setScreenName(screenName);
		ticket.setThreaterName(theaterName);
		ticket.setPrice(calculateTotal(ticket, seats.size()));
		return ticket;
		
	}

	private double calculateTotal(TicketImpl ticket, int numSeats) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Ticket Types\nAdult - a\t Child - c\t Senior - s\n");
		double price = 0;
		do {
			if (("a").equalsIgnoreCase(in.next())) {
				price+=12;
			} else if(("c").equalsIgnoreCase(in.next())) {
				price+=6;
			} else if(("s").equalsIgnoreCase(in.next())) {
				price+=10;
			} 
		} while(in.next() != null && numSeats-- > 0);
		in.close();
		return price;
		
	}

	private List<String> reserveSeats(ScreenImpl screen) {
		Scanner in = new Scanner(System.in);
		List<String> seats = new ArrayList<String>();
		screen.getSeats();
		screen.getReserved();
		System.out.println("Enter the seats to be reserved\n");
		do {
			seats.add(in.next());
		} while(in.next() != null);
		screen.setReserved(seats);
		in.close();
		return seats;		
	}
	
	public List<String> showAvailableSeats(Screen screen) {
		return null;
		// TODO Auto-generated method stub
		
	}
	

}
