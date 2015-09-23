package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	public int addCustomer(Customer customer) {
		return (int) this.sessionFactory.getCurrentSession().save(customer);
		
	}

	public Customer getCustomer(int customerId) {
		return (Customer) this.sessionFactory.getCurrentSession().get(CustomerImpl.class, customerId);
	}
	
	public List<Customer> searchCustomer(String username) {
		List<Customer> searchResult = new ArrayList<>();
		searchResult.addAll((Customer) this.sessionFactory.getCurrentSession().get(CustomerImpl.class, username));
		return searchResult;
	}

	public void updateCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().update(customer);
	}
	
	public void deleteCustomer(int customerId) {
		this.sessionFactory.getCurrentSession().delete(this.getCustomer(customerId));
	}
	
	//account
	public int createAccount(Account account) {
		return (int) this.sessionFactory.getCurrentSession().save(account);
	}
	
	public Account getAccount(int accountId) {
		return (Account) this.sessionFactory.getCurrentSession().get(AccountImpl.class, accountId);
	}
	
	public void updateAccount(Account account) {
		this.sessionFactory.getCurrentSession().update(account);
	}
	
	public void deleteAccount(int accountId) {
		this.sessionFactory.getCurrentSession().delete(this.getAccount(accountId));
	}

}