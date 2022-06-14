package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOimpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProduct(int productId) 
	{
		
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
	}

	@Override
	public List<Product> productList() 
	{
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product" , Product.class)
				.getResultList();
	}

	public boolean addProduct(Product product)
	{
		try 
		{	
			product.setActive(true);
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) 
		{		
			ex.printStackTrace();
			return false;
		}		
		
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		try 
		{			
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) 
		{		
			ex.printStackTrace();
			return false;
			
		}		
		
	}

	@Override
	public boolean deleteProduct(Product product) 
	{
		try 
		{
			
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex) 
		{		
			ex.printStackTrace();
			return false;
		}		
		
	}

	@Override
	public List<Product> listActiveProducts() 
	{
		String selectActiveCategory = "FROM Product WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) 
	{
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory);
		query.setParameter("active", true);
		query.setParameter("categoryId",categoryId);
		
		return query.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) 
	{
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
		
	}

}