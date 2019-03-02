package com.research.services.locator;

import com.research.services.constants.Constants;
import com.research.services.locator.repositories.SchoolRepository;
import com.research.services.locator.repositories.StudentRepository;
import com.research.services.locator.services.SchoolService;
import com.research.services.locator.services.StudentService;

public class InitialContext {
	   public Object lookup(String jndiName) throws Exception{
	   
		   Object service;
		   
		   System.out.println("Looking up and creating a new Service object");
		   
		   switch(jndiName){
		   
		   		case Constants.NAMING_SERVICE_SCHOOLS:

		   			service = new SchoolService(); 
		   			
		   			break;
		   		case Constants.NAMING_SERVICE_STUDENTS:			   
		   			
		   			service = new StudentService();
		   			
		   			break;
		   		case Constants.NAMING_REPOSIT_SCHOOLS:			   
		   			
		   			service = new SchoolRepository();
		   			
		   			break;

		   		case Constants.NAMING_REPOSIT_STUDENTS:			   
		   			
		   			service = new StudentRepository();
		   			
		   			break;
		   			
		   			
		   		default:
		   			
		   			service = null;
		   }
		   
		  //System.out.println((service!=null)? String.format("Found the requested service object: %s",service.getName()) : "Requested service was not found!");
	      return service;		
	   }
	}