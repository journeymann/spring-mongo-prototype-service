package com.research.services.controllers;

/**
 * REST Controller class
 * @author cgordon
 *
 */
import javax.ws.rs.core.MediaType;

import java.util.List;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.research.services.exceptions.ServiceException;
import com.research.services.locator.ServiceLocator;
import com.research.services.locator.services.AbstractService;
import com.research.services.model.BaseEntity;
import com.research.services.constants.Constants;

@RestController
@RequestMapping( path="/api/{service}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON )
public class ResearchController {
	
	@RequestMapping( path="/item/{id}", method = { RequestMethod.GET })
	public Document get(@RequestParam(value="id", required=true) String id, @PathVariable("service") String table, @RequestBody BaseEntity body) throws ServiceException{
		
		try{
			return Document.parse(((AbstractService)ServiceLocator.getResource(table)).getEntity(id).toString());
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}	

	@RequestMapping( method = { RequestMethod.GET})
	public List<? extends Document> getAll( @PathVariable("service") String table ) throws ServiceException{
		
		try{
			return ((AbstractService)ServiceLocator.getResource(table)).getAllEntities();
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}

	@RequestMapping(  path="/item", method = { RequestMethod.POST })
	public String insert(@PathVariable("service") String table, @RequestBody BaseEntity entity) throws ServiceException{
		
		try{
			return ((AbstractService)ServiceLocator.getResource(table)).addEntity(entity)? Constants.SUCCESS : Constants.FAIL;
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}

	@RequestMapping( method = { RequestMethod.POST })
	public String insertAll( @PathVariable("service") String table)  throws ServiceException{
		
		try{
			return (((AbstractService)ServiceLocator.getResource(table)).insertAll())? Constants.SUCCESS : Constants.FAIL;
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}

	@RequestMapping(  path="/item/{id}", method = { RequestMethod.DELETE })	
	public String delete(@RequestParam(value="id", required=true) String id, @PathVariable("service") String table) throws ServiceException{
		
		try{
			return (((AbstractService)ServiceLocator.getResource(table)).removeEntityById(id))? Constants.SUCCESS : Constants.FAIL;
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}

	@RequestMapping( method = { RequestMethod.DELETE })
	public String deleteAll( @PathVariable("service") String table) throws ServiceException{
		
		try{
			return (((AbstractService)ServiceLocator.getResource(table)).removeAll())? Constants.SUCCESS : Constants.FAIL;		
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}

	@RequestMapping( method = { RequestMethod.PUT })
	public String update(@PathVariable("service") String table, @RequestBody BaseEntity entity)  throws ServiceException{

		try{
			return ((AbstractService)ServiceLocator.getResource(table)).updateEntity(entity)? Constants.SUCCESS : Constants.FAIL;			
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
	}
	
}
