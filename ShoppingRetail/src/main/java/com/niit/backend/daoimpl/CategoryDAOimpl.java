package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOimpl implements CategoryDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Category getCategory(int id) 
	{
		return sessionFactory.getCurrentSession().get(Category.class,id );
		
	}

	@Override
	public List<Category> categoryList() 
	{
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();

	}

	@Override
	public boolean insert(Category category) 
	{

		try
		{
			category.setActive(true);
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) 
	{

		category.setActive(false);
		
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	

}
