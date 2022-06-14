package com.niit.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.User;

public class testUser 
{
private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
	
	/*@Test
	public void testAddUser() 
	{
		
		user = new User() ;
		user.setFirstName("Anil");
		user.setLastName("Kumar");
		user.setEmail("ak@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUserId(user.getId());
			
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		
		
		if(user.getRole().equals("USER"))
		{
		
			cart = new Cart();
		
			cart.setUser(user);
		
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
	
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			address.setUserId(user.getId());
		
			assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		}
		
	}
	
	*/

	/*
	@Test
	public void testAddUser()
	{
		user = new User() ;
		user.setFirstName("Anil");
		user.setLastName("Kumar");
		user.setEmail("ak@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
	
	
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
	
			cart.setUser(user);
		
			user.setCart(cart);
	
		}
	
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
	
	}
	
	
	@Test
	public void testUpdateCart() 
	{
		user = userDAO.getByEmail("ak@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	}

	*/
	
	
	@Test
	public void testAddAddress() 
	{
		
		user = new User() ;
		user.setFirstName("Anil");
		user.setLastName("Kumar");
		user.setEmail("ak@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
	
	
		if(user.getRole().equals("USER"))
		{
			cart = new Cart();
	
			cart.setUser(user);
		
			user.setCart(cart);
	
		}
	
		
		
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		address.setUserId(user.getId());
			
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		
	
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		address.setUserId(user.getId());
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}
	
	/*
	@Test
	public void testAddAddress() 
	{
		
		
		
		user = userDAO.getByEmail("ak@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Kolkata");
		address.setState("WestBengal");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		address.setUser(user);
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		
	}
	*/
}