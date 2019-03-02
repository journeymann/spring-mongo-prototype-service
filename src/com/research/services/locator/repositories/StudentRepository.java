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
import com.research.services.model.Student;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Student}s
 */
@Repository
public class StudentRepository extends AbstractRepository implements ResourceInterface{

  static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
  @Autowired
  MongoTemplate mongoTemplate;

	private String repositoryname = Constants.NAMING_REPOSIT_STUDENTS; 
	
	public void execute(){
		  System.out.println(String.format("Executing %s", repositoryname));
	}

	@Override
	public String getName() {
		 return repositoryname;
	}	

  public void logAllStudent() {
    List<Student> results = mongoTemplate.findAll(Student.class);
    logger.info("Total amount of students: {}", results.size());
    logger.info("Results: {}", results);
  }

  public boolean insertStudent(Student student){
  
    mongoTemplate.insert(student);
    return true;
  }

  /**
    * Create a {@link Student} collection if the collection does not already exists
    */
  public boolean createStudentCollection() {
    if (!mongoTemplate.collectionExists(Student.class)) {
      mongoTemplate.createCollection(Student.class);
      return true;
    }
    return false;
  }

  /**
   * Returns all {@link Student} collection if the collection does already exists
   */

 public List<Document> findStudentCollection() {
	   if (mongoTemplate.collectionExists(Student.class)) {
	     
		 List<Document> list =  new ArrayList<Document>();  
		 for(Student student : mongoTemplate.findAll(Student.class)){
			 list.add(Document.parse(student.toString()));
		 }
		   
	     return list;
	   }
	   return new ArrayList<Document>();
	 } 
 
 /**
  * Returns all {@link Student} collection if the collection does already exists
  */
public Document findStudentById(String id) {
  if (mongoTemplate.collectionExists(Student.class)) {
    return Document.parse(mongoTemplate.findById(id, Student.class).toString());
  }
  return new Document();
}

 
/**
 * Adds {@link Student} to collection if it does not exists
 */
public boolean addSchoolToCollection(Student student) {
 if (mongoTemplate.collectionExists(Student.class)) {
	 
	 if(mongoTemplate.findById(student.getId(), Student.class) != null){
		 mongoTemplate.insert(student);
		 return true;
	 }
 }
 return false;
}

/**
 * Adds {@link Student} to collection if it does not exists
 */
public boolean updateStudentInCollection(Student student) {
 if (mongoTemplate.collectionExists(Student.class)) {
	 
	 if(mongoTemplate.findById(student.getId(), Student.class) != null){
		 mongoTemplate.remove(mongoTemplate.findById(student.getId(), Student.class));
		 mongoTemplate.insert(student);
		 return true;
	 }
 }
 return false;
}

/**
 * Removes {@link Student} from collection if it exists
 */
public boolean removeStudentById(String id) {
 if (mongoTemplate.collectionExists(Student.class)) {
	 mongoTemplate.remove( mongoTemplate.findById(id, Student.class));
	 return true;
 }
 return false;
}

/**
 * Removes {@link Student} from collection if it exists
 */
public boolean removeSchoolFromCollection(Student student) {
 if (mongoTemplate.collectionExists(Student.class)) {
		 mongoTemplate.remove(student);
		 return true;
 }
 return false;
}

  /**
   * Drops the {@link Student} collection if the collection does already exists
   */
   public boolean dropStudentCollection() {
     if (mongoTemplate.collectionExists(Student.class)) {
       mongoTemplate.dropCollection(Student.class);
       return true;
     }
     return false;
   }
   
   /**
    * Returns the size of the {@link Student data-set collection.
    */
	public long getSize(){
		
	     if (mongoTemplate.collectionExists(Student.class)) {
	         return(long)mongoTemplate.findAll(Student.class).size();
	         
	       }
	     return -1;
	};
   
   
}
