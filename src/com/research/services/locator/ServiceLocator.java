package com.research.services.locator;

/**
 * Custom implementation of the service locator design pattern.
 * 
 * Used primarily for:
 * 	i) Service resources
 *  ii) Repository resources 
 * 
 */
import com.research.services.constants.Constants;
import com.research.services.exceptions.ServiceException;

public class ServiceLocator {
	   private static Cache cache;

	   static {
	      cache = new Cache();		
	   }

	   public static ResourceInterface getResource(String jndiName) throws ServiceException, Exception{

		  if (!Constants.resourceTypes.contains(jndiName)) throw new ServiceException(Constants.errorCodeMap.get(Constants.STATUS_RESOURCE_NOT_FOUND).getMessage());
		   
		  ResourceInterface service = cache.getResource(jndiName);

	      if(service != null){
	         return service;
	      }

	      InitialContext context = new InitialContext();
	      ResourceInterface service1 = (ResourceInterface)context.lookup(jndiName);
	      cache.addResource(service1);
	      return service1;
	   }
	   
	}