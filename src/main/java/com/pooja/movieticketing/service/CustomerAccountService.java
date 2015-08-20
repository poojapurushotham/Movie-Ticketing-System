package com.pooja.movieticketing.service;

public interface CustomerAccountService {
	
	public void createAccount();
	public void readAccount(String accountId);
	public void updateAccount(String accountId);
	public void deleteAccount(String accountId);
	public void viewBookingHistory(String accountId);
	public boolean isPasswordValid(String customerId, String password);
}
