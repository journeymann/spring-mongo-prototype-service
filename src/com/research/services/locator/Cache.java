package com.research.services.locator;

import java.util.ArrayList;
import java.util.List;

public class Cache {

   private List<ResourceInterface> resources;

   public Cache(){
	   resources = new ArrayList<ResourceInterface>();
   }

   public void addResource(ResourceInterface newResource){
      boolean exists = false;
      
            
      
      for (ResourceInterface service : resources) {
         if(service.getName().equalsIgnoreCase(newResource.getName())){
            exists = true;
         }
      }
      if(!exists){
    	  resources.add(newResource);
      }
   }

   public ResourceInterface getResource(String resourceName){
   
	   for (ResourceInterface resource : resources) {
	      if(resource.getName().equalsIgnoreCase(resourceName)){
	         System.out.println("Returning cached  " + resourceName + " object");
	         return resource;
	      }
	   }
	   return null;
   }
}