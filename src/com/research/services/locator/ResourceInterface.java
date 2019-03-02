package com.research.services.locator;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 * As a policy these methods should always return a org.bson.Document instance class.
 *
 */

public interface ResourceInterface {

	   	public String getName();
	   	
	   	public void execute();
	   	
	   
}