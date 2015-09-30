package com.pooja.movieticketing.entity.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Account;
import com.pooja.movieticketing.entity.Customer;

@Entity
@Table(name="customer")
public class CustomerImpl implements Customer {
	
	@Id
	@Column(name="idcustomer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name="username")
	private String custName;
	
	@Column(name="customer_address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private long zip;
	
	@Column(name="country")
	private String country;
	
	@Column(name="phone")
	private String phone;
	
	@OneToOne(targetEntity=AccountImpl.class, optional=true, cascade=CascadeType.ALL, mappedBy="customer")
	private Account account;
	
	//constructor
	public CustomerImpl() {}
	
	public int getCustomerId() {
		return customerId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZip() {
		return zip;
	}
	public void setZip(long zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CustomerImpl [customerId=" + customerId + ", custName="
				+ custName + ", address=" + address + ", email=" + email
				+ ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", country=" + country + ", phone=" + phone + ", account="
				+ account + "]";
	}
}
