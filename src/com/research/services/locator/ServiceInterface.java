package com.research.services.locator;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.util.List;
import com.research.services.model.BaseEntity;
import com.research.services.repositories.AbstractRepository;


public interface ServiceInterface {

	   	public String getName();
	   	
	   	public void execute();
	   
		public void initData();
			
		public List<? extends BaseEntity> getAllEntities();

		public BaseEntity getEntity(String entityid);
		
		public boolean addEntity(BaseEntity entity);
		
		public boolean insertAll();
		
		public boolean removeEntity(BaseEntity entity);
		
		public boolean removeEntityById(String entityid);
		
		public boolean updateEntity(BaseEntity entity);
		
		public boolean removeAll();
		
		public AbstractRepository getEntityRepo();

		public void setEntityRepo(AbstractRepository repo);
}