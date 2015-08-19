package com.pooja.movieticketing.service;

import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Ticket;

public interface TicketingService {
	public void buyTicket();
	public void calculateTotal(Ticket ticket);
	public void reserveSeats(Screen screen);
}
