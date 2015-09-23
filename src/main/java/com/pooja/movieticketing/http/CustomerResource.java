package com.pooja.movieticketing.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.impl.CustomerImpl;
import com.pooja.movieticketing.http.entity.HttpCustomer;
import com.pooja.movieticketing.service.CustomerAccountService;
//import com.pooja.movieticketing.service.exception.TBTFException;
import com.pooja.movieticketing.service.exception.TBTFException;

@Path("/customers")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CustomerResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CustomerAccountService customerService;
	
	@POST
	@Path("/")
	
	public Response createCustomer(HttpCustomer newCustomer){
		Customer customerToCreate = convert(newCustomer);
		Customer addedCustomer = customerService.addCustomer(customerToCreate);
		return Response.status(Status.CREATED).header("Location", "/customers/"+addedCustomer.getCustomerId()).entity(new HttpCustomer(addedCustomer)).build();
	}	

	@GET
	@Path("/{customerId}")	
	public HttpCustomer getCustomerById(@PathParam("customerId") int customerId){
		logger.info("getting Customer by id:" + customerId);
		Customer customer = customerService.getCustomer(customerId);	
		return new HttpCustomer(customer);
	}
	
	@GET
	@Path("/")
	@Wrapped(element="customers")
	public List<HttpCustomer> getCustomerSearch(@QueryParam("username") String custName) throws TBTFException{
		List<Customer> found = customerService.getCustomer(custName);
		List<HttpCustomer> returnList = new ArrayList<>(found.size());
		for(Customer customer:found){
			returnList.add(new HttpCustomer(customer));
		}
		return returnList;
	}
	
	private Customer convert(HttpCustomer httpCustomer) {
		CustomerImpl customer = new CustomerImpl();
		customer.setCustName(httpCustomer.username);
		customer.setEmail(httpCustomer.emailId);
		customer.setPassword(httpCustomer.password);
		return customer;
	}	
}
