package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Ticket;

public interface TicketingService {
	public Ticket buyTicket(Showtime show, String movieName, String theaterName, String custType, int seatNum, double discount);
	
	public List<Ticket> viewBookingHistory(int accountId);
}
