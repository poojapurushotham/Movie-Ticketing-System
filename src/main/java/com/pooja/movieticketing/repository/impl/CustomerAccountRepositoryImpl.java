package com.pooja.movieticketing.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.impl.AccountImpl;
import com.pooja.movieticketing.entity.impl.CustomerImpl;
import com.pooja.movieticketing.repository.CustomerAccountRepository;

@Repository
public class CustomerAccountRepositoryImpl implements CustomerAccountRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	//customer
	@Override
	public int addCustomer(Customer customer) {
		return (int) this.sessionFactory.getCurrentSession().save(customer);
		
	}

	@Override
	public Customer getCustomer(int customerId) {
		return (Customer) this.sessionFactory.getCurrentSession().get(CustomerImpl.class, customerId);
	}
	
	@Override
	public List<Customer> searchCustomer(String username) {
		List<Customer> searchResult = new ArrayList<>();
		searchResult.add((Customer) this.sessionFactory.getCurrentSession().get(CustomerImpl.class, username));
		return searchResult;
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().update(customer);
	}
	
	@Override
	public void deleteCustomer(int customerId) {
		this.sessionFactory.getCurrentSession().delete(this.getCustomer(customerId));
	}
	
	//account
	@Override
	public int createAccount(Account account) {
		return (int) this.sessionFactory.getCurrentSession().save(account);
	}
	
	@Override
	public Account getAccount(int accountId) {
		return (Account) this.sessionFactory.getCurrentSession().get(AccountImpl.class, accountId);
	}
	
	@Override
	public void updateAccount(Account account) {
		this.sessionFactory.getCurrentSession().update(account);
	}
	
	@Override
	public void deleteAccount(int accountId) {
		this.sessionFactory.getCurrentSession().delete(this.getAccount(accountId));
	}

}