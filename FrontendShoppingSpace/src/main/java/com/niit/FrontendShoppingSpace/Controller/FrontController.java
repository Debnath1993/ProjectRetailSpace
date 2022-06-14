package com.niit.FrontendShoppingSpace.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Backend.dao.CategoryDAO;
import com.niit.Backend.dao.ProductDAO;
import com.niit.Backend.dto.Category;
import com.niit.Backend.dto.Product;

@Controller
public class FrontController {
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() 
	{
		logger.info("Inside FrontController index method - INFO");
		logger.debug("Inside FrontController index method - DEBUG");
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		mav.addObject("ClickHome", true);
		mav.addObject("categories", categoryDAO.categoryList());
		return mav;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() 
	{
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("ClickAbout", true);
		return mav;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("ClickContact", true);
		return mav;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.categoryList());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.getCategory(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.categoryList());
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);

		return mv;
	}

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.getProduct(id);

		product.setViews(product.getViews() + 1);

		productDAO.updateProduct(product);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userClickSingleProduct", true);

		return mv;
	}
	
	
	@RequestMapping(value = "/register")
	public ModelAndView register() 
	{
		ModelAndView mv = new ModelAndView("page");
		return mv;
	}
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,@RequestParam(name="logout", required = false)	String logout) 
	{
		ModelAndView mv = new ModelAndView("login");
		
		if(error!= null) 
		{
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!= null) 
		{
			mv.addObject("logout", "You have successfully logged out.");
		}
		
		mv.addObject("title","LOGIN");
		return mv;
	}
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() 
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "!!! Caught You. !!!");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");	
		return mv;
	}
	
	@RequestMapping(value = "/custom-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
	    return "redirect:/login?logout";
	}


}