package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;

public interface CustomerAccountService {
	
	//customer
	public Customer addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);

	public Customer getCustomer(int customerId);
	
	public List<Customer> getCustomer(String username);
	
	public void deleteCustomer(int customerId);
	
	//account
	public Account createAccount(Account account);
	
	public Account getAccount(int accountId);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int accountId);
	
	public boolean isPasswordValid(int curomerId, String password);
}
