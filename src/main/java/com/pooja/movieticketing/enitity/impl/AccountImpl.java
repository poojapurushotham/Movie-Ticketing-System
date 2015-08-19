package com.pooja.movieticketing.enitity.impl;

import java.util.List;

import com.pooja.movieticketing.enitity.Account;

public class AccountImpl implements Account {
	private String accountId;
	private String accountType;
	private String paymetType;
	private Long cardNum;
	private String firstName;
	private String lastName;
	private String expMonth;
	private String expYear;
	private String zip;
	private String cvv;
	private List<String> purchases;
	
	public AccountImpl(String accountId) {
		this.accountId=accountId;
	}
	
	public List<String> getPurchases() {
		return purchases;
	}
	public void setPurchases(String ticketId) {
		purchases.add(ticketId);
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPaymetType() {
		return paymetType;
	}
	public void setPaymetType(String paymetType) {
		this.paymetType = paymetType;
	}
	public Long getCardNum() {
		return cardNum;
	}
	public void setCardNum(Long cardNum) {
		this.cardNum = cardNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
