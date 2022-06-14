package com.niit.FrontendShoppingSpace.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.dao.CategoryDAO;
import com.niit.Backend.dao.ProductDAO;
import com.niit.Backend.dto.Category;
import com.niit.Backend.dto.Product;
import com.niit.Frontend.util.FileUtil;
import com.niit.Frontend.validator.ProductValidate;

@Controller
@RequestMapping("/manage")
public class ManageProductController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManageProductController.class);

	@RequestMapping("/product")
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation) 
	{		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Manage Product");		
		mv.addObject("userClickManageProduct",true);
		

		Product product = new Product();
	
		product.setSupplierId(1);
		product.setActive(true);

		mv.addObject("product", product);

		
		if(operation != null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully!");
			}
			
			if(operation.equals("category"))
			{
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		return mv;
		
	}
	
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() 
	{
		return categoryDAO.categoryList();
	}
	

	@ModelAttribute("category")
	public Category modelCategory() 
	{
		return new Category();
	}
	
	
	@RequestMapping(value = "/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product newProduct,BindingResult results, Model model, HttpServletRequest request)
	{
		if(newProduct.getId() == 0)
		{
			new ProductValidate().validate(newProduct,results);
		}
		else
		{
			if(!newProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidate().validate(newProduct,results);
			}
		}
		
		
		if(results.hasErrors()) 
		{
			
			model.addAttribute("userClickManageProduct",true);
			model.addAttribute("title","Product Management");
			//model.addAttribute("message", "Validation fails for adding the product!");
			return "page";
		}
		
		if(newProduct.getId() == 0)
		{
			productDAO.addProduct(newProduct);
		}
		else
		{
			productDAO.updateProduct(newProduct);
		}
		
		if(!newProduct.getFile().getOriginalFilename().equals("") )
		{
			FileUtil.uploadFile(request, newProduct.getFile(), newProduct.getCode()); 
		 }
		logger.info(newProduct.toString());
		logger.debug("Inside PageController index method - DEBUG");
		
		
		
		return "redirect:/manage/product?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductAvtivation(@PathVariable int id)
	{
		Product product = productDAO.getProduct(id);
		
		boolean isActive = product.isActive();
		
		product.setActive(!isActive);
		
		productDAO.updateProduct(product);	
		
		
		return (isActive)? 
				"Successfully Deactivated the product with id : " +product.getId()
				: "Successfully Activated the product with id : " +product.getId();
	}
	

	
	@RequestMapping(value = "/{id}/product", method=RequestMethod.GET)
	public ModelAndView handleProductEdit(@PathVariable int id)
	{
		
		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		Product product = productDAO.getProduct(id);
		
		mv.addObject("product", product);
		
		return mv;
	}
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category mCategory) 
	{					
		
		mCategory.setActive(true);
		
		categoryDAO.insert(mCategory);
		
		return "redirect:/manage/product?operation=category";
	}
	
}