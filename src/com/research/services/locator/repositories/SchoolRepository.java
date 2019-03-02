package com.research.services.locator.repositories;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.research.services.constants.Constants;
import com.research.services.locator.ResourceInterface;
import com.research.services.model.School;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link School}s
 */
@Repository
public class SchoolRepository extends AbstractRepository implements ResourceInterface{

  static final Logger logger = LoggerFactory.getLogger(SchoolRepository.class);
  @Autowired
  MongoTemplate mongoTemplate;
  
  
	private String repositoryname = Constants.NAMING_REPOSIT_SCHOOLS; 
	
	public void execute(){
		  System.out.println(String.format("Executing %s", repositoryname));
	}

	@Override
	public String getName() {
		 return repositoryname;
	}	


  public void logAllSchool() {
    List<School> results = mongoTemplate.findAll(School.class);
    logger.info("Total amount of schools: {}", results.size());
    logger.info("Results: {}", results);
  }

  public boolean insertSchool(School school){
  
    mongoTemplate.insert(school);
    
    return true;
  }

  /**
    * Create a {@link School} collection if the collection does not already exists
    */
  public void createSchoolCollection() {
    if (!mongoTemplate.collectionExists(School.class)) {
      mongoTemplate.createCollection(School.class);
    }
  }

  /**
   * Returns all {@link School} collection if the collection does already exists
   */
 public List<Document> findSchoolCollection() {
   if (mongoTemplate.collectionExists(School.class)) {
     
	 List<Document> list =  new ArrayList<Document>();  
	 for(School school : mongoTemplate.findAll(School.class)){
		 list.add(Document.parse(school.toString()));
	 }
	   
     return list;
   }
   return new ArrayList<Document>();
 }
  
 /**
  * Returns all {@link School} collection if the collection does already exists
  */
public Document findSchoolById(String id) {
  if (mongoTemplate.collectionExists(School.class)) {
    return Document.parse(mongoTemplate.findById(id, School.class).toString());
  }
  return new Document();
}

/**
 * Adds {@link School} to collection if it does not exists
 */
public boolean addSchoolToCollection(School school) {
 if (mongoTemplate.collectionExists(School.class)) {
	 
	 if(mongoTemplate.findById(school.getId(), School.class) != null){
		 mongoTemplate.insert(school);
		 return true;
	 }
 }
 return false;
}

/**
 * Updates {@link School} to collection if it does not exists
 */
public boolean updateSchoolInCollection(School school) {
 if (mongoTemplate.collectionExists(School.class)) {
	 
	 if(mongoTemplate.findById(school.getId(), School.class) != null){
		 mongoTemplate.remove(mongoTemplate.findById(school.getId(), School.class));
		 mongoTemplate.insert(school);
		 return true;
	 }
 }
 return false;
}

/**
 * Removes {@link School} from collection if it exists
 */
public boolean removeSchoolById(String id) {
 if (mongoTemplate.collectionExists(School.class)) {
	 mongoTemplate.remove( mongoTemplate.findById(id, School.class));
	 return true;
 }
 return false;
}

/**
 * Removes {@link School} from collection if it exists
 */
public boolean removeSchoolFromCollection(School school) {
 if (mongoTemplate.collectionExists(School.class)) {
		 mongoTemplate.remove(school);
		 return true;
 }
 return false;
}


  /**
   * Drops the {@link School} collection if the collection does already exists
   */
   public boolean dropSchoolCollection() {
     if (mongoTemplate.collectionExists(School.class)) {
       mongoTemplate.dropCollection(School.class);
       return true;
     }
     return false;
   }
   
   
   /**
    * Returns the size of the {@link School} data-set collection.
    */
	public long getSize(){
		
	     if (mongoTemplate.collectionExists(School.class)) {
	         return(long)mongoTemplate.findAll(School.class).size();
	         
	       }
	     return -1;
	};
	

}
