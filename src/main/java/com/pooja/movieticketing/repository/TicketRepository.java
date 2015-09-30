package com.pooja.movieticketing.repository;

import java.util.List;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.Ticket;

public interface TicketRepository {
	
	public int addTicket(Ticket ticket);

	public Ticket getTicket(int ticketId);
	
	public void updateTicket(Ticket ticket);
	
	public void deleteTicket(int ticketId);
	
	public List<Ticket> getTicketsPurchasedByAccount(int accountId);
	
}	