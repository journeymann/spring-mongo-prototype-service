package com.research.services.locator.services;

import java.util.List;
import org.bson.Document;
import com.research.services.locator.repositories.AbstractRepository;
import com.research.services.model.BaseEntity;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 * As a policy these methods should always return a org.bson.Document instance class.
 *
 */

public abstract class AbstractService{

	   	public abstract void initData();
		
	   	public abstract List<? extends Document> getAllEntities();

	   	public abstract Document getEntity(String entityid);
		
	   	public abstract boolean addEntity(BaseEntity entity);
		
	   	public abstract boolean insertAll();
		
	   	public abstract boolean removeEntity(BaseEntity entity);
		
	   	public abstract boolean removeEntityById(String entityid);
		
	   	public abstract boolean updateEntity(BaseEntity entity);
		
	   	public abstract boolean removeAll();
		
	   	public abstract AbstractRepository getEntityRepo();

	   	public abstract void setEntityRepo(AbstractRepository repo);
}