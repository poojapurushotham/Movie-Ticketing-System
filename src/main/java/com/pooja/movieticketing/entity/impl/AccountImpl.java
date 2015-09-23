package com.pooja.movieticketing.entity.impl;

import java.util.ArrayList;
import java.util.List;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.Ticket;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="account")
public class AccountImpl implements Account {
	
	@Id
	@Column(name="idaccount")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="payment_type")
	private String paymetType;
	
	@Column(name="card_num")
	private Long cardNum;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="exp_month")
	private String expMonth;
	
	@Column(name="exp_year")
	private String expYear;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="cvv")
	private String cvv;
	
	@OneToMany(mappedBy = "account", targetEntity=TicketImpl.class, cascade=CascadeType.ALL)
	private List<Ticket> purchases;
	
	@OneToOne(targetEntity=CustomerImpl.class, optional=true, cascade=CascadeType.ALL, mappedBy="account")
	@JoinColumn(name="customer_idcustomer")
	private Customer customer;
	
	//constructor
	public AccountImpl() {}
	
	public int getAccountId() {
		return accountId;
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
	
	public List<Ticket> getPurchases() {
		return purchases;
	}
	
	public void addUserAuditHistory(Ticket purchase) {
		if(this.purchases==null){
			this.purchases = new ArrayList<Ticket>();
		}
		this.purchases.add(purchase);
	}
	
	@Override
	public String toString() {
		return "AccountImpl [accountId=" + accountId + ", accountType="
				+ accountType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", zip=" + zip + ", customer=" + customer + "]";
	}
}
