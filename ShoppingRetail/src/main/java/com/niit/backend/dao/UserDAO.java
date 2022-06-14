package com.niit.backend.dao;



import java.util.List;

import com.niit.backend.dto.*;


public interface UserDAO 
{

	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean updateCart(Cart cart);
	
	User getByEmail(String email) ;
	
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddresses(int userId);
	
	Address getAddress(int addressId);
}