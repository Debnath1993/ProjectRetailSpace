package com.niit.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dto.Product;



public class testProduct 
{

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	
	/*
	@Test
	public void testGetProduct()
	{
		product = productDAO.getProduct(3);
		
		assertEquals("Error extracting sigle product" , "Google Pixel",product.getName());
	}
	
	
	@Test
	public void testProductlist()
	{
		assertEquals("Error fetcheing the list of categories from the table!",5,productDAO.productList().size());
		
	}
	
	
	
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.addProduct(product));
	}
	
	
	@Test
	public void testUpdateProduct()
	{

		product = productDAO.getProduct(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.updateProduct(product));
	}

	
	@Test
	public void testDeleteProduct()
	{
		product = productDAO.getProduct(2);
		assertEquals("Something went wrong while deleting the existing record!",
				true,productDAO.deleteProduct(product));		
		
	}
	
	
	@Test
	public void testListActiveProducts() 
	{
		assertEquals("Something went wrong while fetching the list of products!",
				4,productDAO.listActiveProducts().size());				
	}
	
	@Test
	public void testListActiveProductsByCategory() 
	{
			assertEquals("Something went wrong while fetching the list of products!",
					2,productDAO.listActiveProductsByCategory(3).size());
					
			assertEquals("Something went wrong while fetching the list of products!",
					2,productDAO.listActiveProductsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() 
	{
			assertEquals("Something went wrong while fetching the list of products!",
					3,productDAO.getLatestActiveProducts(3).size());
			
	} 
	*/
	
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		
		product.setName("Sony Bravia X7002G");
		product.setBrand("Sony");
		product.setDescription("This is some description for Sony Bravia television!");
		product.setUnitPrice(44999);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(1);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.addProduct(product));
	}
}