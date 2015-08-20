package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Ticket;
import com.pooja.movieticketing.enitity.impl.ScreenImpl;
import com.pooja.movieticketing.enitity.impl.TicketImpl;

public interface TicketingService {
	public TicketImpl getTicket(String ticketId);
	
	public ScreenImpl getScreen(String screenName);
	
	public TicketImpl buyTicket(String screenName, String movieName, String theaterName, double discount);
}
