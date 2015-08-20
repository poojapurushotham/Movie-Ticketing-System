package com.pooja.movieticketing.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pooja.movieticketing.enitity.Ticket;
import com.pooja.movieticketing.enitity.impl.AccountImpl;
import com.pooja.movieticketing.enitity.impl.TicketImpl;
import com.pooja.movieticketing.service.CustomerAccountService;
import com.pooja.movieticketing.service.MovieService;
import com.pooja.movieticketing.service.TheaterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerAccountService {
	
	@Autowired
	private TheaterService theaterService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieService ticketingService;
	
	
	public void createAccount() {
		// TODO Auto-generated method stub
	}

	public void readAccount(String accountId) {
		// TODO Auto-generated method stub
		
	}

	public void updateAccount(String accountId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isPasswordValid(String customerId, String password) {
		if(customerId.equals("User1") && "1234".equals(password)){
			return true;
		}
		return false;
	}
	
	public AccountImpl getAccount(String accountId) {
		return new AccountImpl(accountId);
	}

	public void viewBookingHistory(String accountId) {
		// TODO Auto-generated method stub
		List<TicketImpl> tickets = new ArrayList<TicketImpl>(); 
		AccountImpl acc = getAccount(accountId);
		for (String t : acc.getPurchases()) {
			tickets.add(new TicketImpl(t));
		}
		for (TicketImpl t : tickets) {
			System.out.println("Ticket Number" + t.getTicketId() + "Price" + t.getPrice() + "Seats" + t.getSeatNum());
		}
	}
	

}
