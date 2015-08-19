package com.pooja.movieticketing.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pooja.movieticketing.enitity.Ticket;
import com.pooja.movieticketing.enitity.impl.AccountImpl;
import com.pooja.movieticketing.enitity.impl.TicketImpl;
import com.pooja.movieticketing.service.CustomerAccountService;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerAccountService {
	

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

	public void viewBookingHistory(String accountId) {
		// TODO Auto-generated method stub
		List<TicketImpl> tickets = new ArrayList<TicketImpl>();
		AccountImpl acc = new AccountImpl(accountId);
		for (String t : acc.getPurchases()) {
			tickets.add(new TicketImpl(t));
		}
		for (TicketImpl t : tickets) {
			System.out.println("Ticket Number" + t.getTicketId() + "Price" + t.getPrice();
		}
	}
	

}
