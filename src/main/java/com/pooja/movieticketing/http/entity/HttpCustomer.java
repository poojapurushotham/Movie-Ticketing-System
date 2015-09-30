package com.pooja.movieticketing.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pooja.movieticketing.entity.Customer;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author pooja
 *
 */
@XmlRootElement(name = "customer")
public class HttpCustomer {
	
	@XmlElement
	public int id;
	
	@XmlElement
	public String username;
	
	@XmlElement
	public String password;
	
	@XmlElement
	public String emailId;
	
	//required by framework
	protected HttpCustomer() {}

	public HttpCustomer(Customer customer) {
		this.id=customer.getCustomerId();
		this.username=customer.getCustName();
		this.emailId=customer.getEmail();
		//not setting password
	}
	
}
