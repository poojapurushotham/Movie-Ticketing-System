package com.pooja.movieticketing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Ticket;
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

	public void buyTicket() {
		// TODO Auto-generated method stub
		
	}

	public void calculateTotal(Ticket ticket) {
		// TODO Auto-generated method stub
		
	}

	public void reserveSeats(Screen screen) {
		// TODO Auto-generated method stub
		
	}

}
