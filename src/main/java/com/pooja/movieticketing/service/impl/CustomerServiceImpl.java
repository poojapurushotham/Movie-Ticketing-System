package com.pooja.movieticketing.service.impl;

import javax.transaction.Transactional;

import com.pooja.movieticketing.enitity.Account;
import com.pooja.movieticketing.enitity.Customer;
import com.pooja.movieticketing.service.CustomerAccountService;
import com.pooja.movieticketing.repository.CustomerAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerAccountService {
	
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	//customer
	@Transactional
	public int addCustomer(Customer customer) {
		return customerAccountRepository.addCustomer(customer);
	}
	
	@Transactional
	public void updateCustomer(Customer customer) {
		customerAccountRepository.updateCustomer(customer);
		
	}
	
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerAccountRepository.getCustomer(customerId);
	}
	
	@Transactional
	public void deleteCustomer(int customerId) {
		customerAccountRepository.deleteCustomer(customerId);
		
	}

	//account
	@Transactional
	public int createAccount(Account account) {
		return customerAccountRepository.createAccount(account);
	}
	
	@Transactional
	public Account getAccount(int accountId) {
		return customerAccountRepository.getAccount(accountId);
		
	}

	@Transactional
	public void updateAccount(Account account) {
		customerAccountRepository.updateAccount(account);
		
	}

	@Transactional
	public void deleteAccount(int accountId) {
		customerAccountRepository.deleteAccount(accountId);
		
	}
	
	@Transactional
	public boolean isPasswordValid(int customerId, String password) {
		Customer customer = getCustomer(customerId);
		if(customer==null || password==null){
			return false;
		}
		return customer.getPassword()!=null;
	}


}
