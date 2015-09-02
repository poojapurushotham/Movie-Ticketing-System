package com.pooja.movieticketing.repository;

import com.pooja.movieticketing.enitity.Account;
import com.pooja.movieticketing.enitity.Customer;

public interface CustomerAccountRepository {
	//customer
	public int addCustomer(Customer customer);

	public Customer getCustomer(int customerId);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
	//account
	public int createAccount(Account account);
	
	public Account getAccount(int accountId);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int accountId);

}
