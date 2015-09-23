package com.pooja.movieticketing.repository;

import java.util.List;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;

public interface CustomerAccountRepository {
	//customer
	public int addCustomer(Customer customer);

	public Customer getCustomer(int customerId);
	
	public List<Customer> searchCustomer(String username);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
	
	//account
	public int createAccount(Account account);
	
	public Account getAccount(int accountId);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(int accountId);

}
