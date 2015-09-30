package com.pooja.movieticketing.entity;

public interface Customer {
	public String getPassword();
	public int getCustomerId();
	public String getCustName();
	public String getEmail();
	public void setCustName(String string);
	public void setPassword(String string);
	public void setEmail(String string);
}
