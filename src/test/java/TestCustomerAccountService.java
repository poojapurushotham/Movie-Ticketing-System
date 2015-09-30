import junit.framework.Assert;

import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.impl.CustomerImpl;
import com.pooja.movieticketing.repository.CustomerAccountRepository;
import com.pooja.movieticketing.service.CustomerAccountService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestCustomerAccountService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private CustomerAccountService custService;
	
	@Autowired
	private CustomerAccountRepository customerRepository;
	
	@SuppressWarnings("deprecation")
	@Test
	public void addAndGetCustomers(){
		Customer customer = new CustomerImpl();
		customer.setCustName("John"+new Random().nextInt(99999));
		customer.setPassword("1234");
		customer.setEmail("john@gmail.com");
		
		int customerId = customerRepository.addCustomer(customer);
		System.out.println("added id "+ customerId);
		Assert.assertNotSame(0, customerId);		
		
		Customer found = customerRepository.getCustomer(customerId);
		Assert.assertEquals(found.getCustomerId(), customerId);
		Assert.assertEquals(found.getCustName(), customer.getCustName());
		Assert.assertEquals(found.getPassword(), customer.getPassword());
		Assert.assertEquals(found.getEmail(), customer.getEmail());
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testPassword1(){
		Assert.assertEquals(true, custService.isPasswordValid(4,"1234"));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPassword2(){
		Assert.assertEquals(false, custService.isPasswordValid(101,"12345"));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPassword3(){
		Assert.assertEquals(false, custService.isPasswordValid(1,"1234"));

	}
	
}


