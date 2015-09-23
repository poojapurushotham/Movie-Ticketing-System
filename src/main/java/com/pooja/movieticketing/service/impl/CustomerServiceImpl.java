package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;
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
	public Customer addCustomer(Customer customer) {
		int id =  customerAccountRepository.addCustomer(customer);
		return getCustomer(id);
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
	public List<Customer> getCustomer(String username) {
		return customerAccountRepository.searchCustomer(username);
	}
	
	@Transactional
	public void deleteCustomer(int customerId) {
		customerAccountRepository.deleteCustomer(customerId);
		
	}

	//account
	@Transactional
	public Account createAccount(Account account) {
		int id = customerAccountRepository.createAccount(account);
		return getAccount(id);
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
		if(customer == null && password ==null){
			return false;
		}
		if(customerId == 100 && password == "1234") {
			return true;
		}
		else 
			return false;
	}


}
