package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.dto.Category;

public interface CategoryDAO 
{

	Category getCategory(int id);
	List<Category> categoryList();
	boolean insert(Category category);
	boolean update(Category category);
	boolean delete(Category category);
		
}