package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Ticket;
import com.pooja.movieticketing.entity.impl.ScreenImpl;
import com.pooja.movieticketing.entity.impl.TicketImpl;

public interface TicketingService {
	public TicketImpl getTicket(int ticketId);
	
	public ScreenImpl getScreen();
	
	public TicketImpl buyTicket(String screenName, String movieName, String theaterName, double discount);
}
