package com.niit.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dto.Category;

public class testCategory 
{
	
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
	@Test
	public void testInsert()
	{
		category = new Category();
		category.setName("Music System");
		category.setDesc("This is a sample music System category");
		category.setImageurl("Cat_4.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
	}
	/*
		category = new Category();
		category.setName("Laptop");
		category.setDesc("This is a sample Laptop category");
		category.setImageurl("Cat_3.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
		
		category = new Category();
		category.setName("Desktop");
		category.setDesc("This is a sample Desktop category");
		category.setImageurl("Cat_4.png");
		assertEquals("Error inserting a new row into the category Table",true,categoryDAO.insert(category));
	}
	*/
	/*
	@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(33);
		
		category.setName("SmartPhone");

		
		assertEquals("Error updating a records in the category Table",true,categoryDAO.update(category));
		
	}
	
	*/
	
	/*
	@Test
	public void testGetCategory()
	{
		category = categoryDAO.getCategory(33);
		
		assertEquals("Error extracting a single record from the category table","Phone",category.getName());
	}
	
	*/
	
	/*
	@Test
	public void testDelete()
	{
		category = categoryDAO.getCategory(33);
		assertEquals("Error updating a records in the category Table",true,categoryDAO.delete(category));
		
	}
	
	
	@Test
	public void testListCategory() 
	{
					
		assertEquals("Error fetcheing the list of categories from the table!",3,categoryDAO.categoryList().size());
		
		
	}*/

}
