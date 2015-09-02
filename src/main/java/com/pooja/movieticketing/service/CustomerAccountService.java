package com.pooja.movieticketing.service;

import com.pooja.movieticketing.enitity.Account;
import com.pooja.movieticketing.enitity.Customer;

public interface CustomerAccountService {
	
	//customer
	public int addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);

	public Customer getCustomer(int customerId);
	
	public void deleteCustomer(int customerId);
	
	//account
	public int createAccount(Account account);
	
	public Account getAccount(int accountId);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int accountId);
	
	public boolean isPasswordValid(int customerId, String password);
}
