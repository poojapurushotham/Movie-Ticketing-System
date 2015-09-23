import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.pooja.movieticketing.service.CustomerAccountService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"}) 
public class TestCustomerAccountService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private CustomerAccountService custService;

	@SuppressWarnings("deprecation")
	@Test
	public void testPassword1(){
		Assert.assertEquals(true, custService.isPasswordValid(100,"1234"));

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


