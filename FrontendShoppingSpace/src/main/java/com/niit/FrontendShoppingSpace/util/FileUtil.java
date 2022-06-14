package com.niit.FrontendShoppingSpace.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil 
{

	private static final String ABS_PATH = "C:\\SDN\\Niit Dt Project\\NiitShopping\\Frontend\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = null;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		if(! new File(REAL_PATH).exists()) 
		{
			 new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) 
		{
			new File(ABS_PATH).mkdirs();
		}
		

		try 
		{
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + code + ".png"));
			file.transferTo(new File(ABS_PATH + code + ".png"));
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		}
		
		
		return true;
	}
}