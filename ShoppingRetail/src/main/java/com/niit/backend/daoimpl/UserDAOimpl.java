package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.User;



@Repository("userDAO")
@Transactional
public class UserDAOimpl implements UserDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) 
	{
		
		try 
		{			
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) 
	{
		
		try 
		{			
			sessionFactory.getCurrentSession().update(cart);			
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}
	
	@Override
	public User getByEmail(String email) 
	{
		String selectQuery = "FROM User WHERE email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		
		catch(Exception ex) 
		{
			return null;
		}
							
	}
	
	@Override
	public List<Address> listShippingAddresses(int userId) 
	{
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
		
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	@Override
	public Address getAddress(int addressId) {
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}