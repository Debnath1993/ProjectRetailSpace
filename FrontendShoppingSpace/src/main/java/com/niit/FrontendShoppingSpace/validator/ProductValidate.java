package com.niit.FrontendShoppingSpace.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.Backend.dto.Product;

public class ProductValidate implements Validator 
{

	@Override
	public boolean supports(Class<?> productClass) 
	{
		
		return Product.class.equals(productClass);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		
		Product product = (Product) target;
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) 
		{
		
			/*
					errors.rejectValue(attribute name, error code, error message);
					
			*/
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		
		if(! (product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png")) ||
				product.getFile().getContentType().equals("image/gif")
			 )
		{
				errors.rejectValue("file", null, "Please select an image file to upload!");
				return;	
		}
	}

}