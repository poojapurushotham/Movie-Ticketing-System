package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import  org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.repository.TicketRepository;
import com.pooja.movieticketing.entity.Ticket;
import com.pooja.movieticketing.entity.impl.TicketImpl;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addTicket(Ticket ticket) {
		return (int) this.sessionFactory.getCurrentSession().save(ticket);	
	}

	@Override
	public Ticket getTicket(int ticketId) {
		return (Ticket) this.sessionFactory.getCurrentSession().get(TicketImpl.class, ticketId);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		this.sessionFactory.getCurrentSession().update(ticket);
	}
	
	@Override
	public void deleteTicket(int ticketId) {
		this.sessionFactory.getCurrentSession().delete(this.getTicket(ticketId));
	}
	
	@Override
	public List<Ticket> getTicketsPurchasedByAccount(int accountId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TicketImpl.class)
				.add(Restrictions.eq("account_accountid", accountId));	
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = crit.list();
		return tickets;
	}

}