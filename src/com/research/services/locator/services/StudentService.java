package com.research.services.locator.services;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.research.services.constants.Constants;
import com.research.services.exceptions.ServiceException;
import com.research.services.locator.ResourceInterface;
import com.research.services.locator.ServiceLocator;
import com.research.services.locator.repositories.AbstractRepository;
import com.research.services.locator.repositories.StudentRepository;
import com.research.services.model.BaseEntity;
import com.research.services.model.Student;
import com.research.services.model.ext.Address;

public class StudentService extends AbstractService implements ResourceInterface{
	private StudentRepository repository;
	private String servicename = Constants.NAMING_SERVICE_STUDENTS; 
	
	public void execute(){
		  System.out.println(String.format("Executing %s", servicename));
	}

	@Override
	public String getName() {
		 return servicename;
	}	
	
	public StudentService() throws ServiceException, Exception{
		super();
		this.setEntityRepo((StudentRepository)ServiceLocator.getResource(servicename));
	}

	public StudentService(StudentRepository repo) {
		super();
		this.setEntityRepo(repo);
	}

	public void initData(){

		repository.dropStudentCollection();
		
		Student student;
		Address address;
		
		@SuppressWarnings("serial")
		Map<Long, String> firstnames = new HashMap<Long, String>() {
	        {
	        	put(1L, "Nicolos");
	        	put(2L, "Junior");
	        	put(3L, "Sandaram");
	        	put(4L, "Nichole");
	        	put(5L, "Ahmed");
	        	put(6L, "Chris");
	        	put(7L, "Ron");	        	
	        	put(8L, "Katherine");	        	
	    	    put(9L, "Leslie");	        			
	        	
	        };
	    };

	    @SuppressWarnings("serial")
		Map<Long, String> lastnames = new HashMap<Long, String>() {
	        {

	        	put(1L, "Reid");
	        	put(2L, "Johnson");
	        	put(3L, "Gordon");
	        	put(4L, "Mistry");
	        	put(5L, "Sundaram");
	        	put(6L, "Gallagher");
	        	put(7L, "Baynes");
	        	
	        };
	    };
		
	    @SuppressWarnings("serial")	    
		Map<Long, String> streets = new HashMap<Long, String>() {
	        {
	        	put(1L,"Campus Drive");
	        	put(2L, "E 99th Street");
	        	put(3L, "W 50th Street");
	        	put(4L, "Dunkirk Ave");
	        	put(5L, "Roland Lane");
	        	put(6L, "Tilden Ave"); 
	        	put(7L, "Brookhaven Blvd");	        	
        	
	        };
	    };
	    
	    @SuppressWarnings("serial")	    
		Map<Long, String> states = new HashMap<Long, String>() {
	        {
	        	put(1L, "NY");
	        	put(2L, "NJ");
	        	put(3L, "CT");
	        	put(4L, "PA");
	        	put(5L, "DE");
	        	put(6L, "MA");
	        	put(7L, "MN");	        	
	        	put(8L, "VT");	        	
	        	put(9L, "VA");
	        	put(10L, "MD");
	        	put(11L, "WV");
	        };
	    };
	    
	    @SuppressWarnings("serial")	    
		Map<Long, String> cities = new HashMap<Long, String>() {
	        {
	        	put(1L,"Brooklyn");
	        	put(2L, "Queens");
	        	put(3L, "Manhattan");
	        	put(4L, "Staten Island");
	        	put(5L, "Bronx");
	        	put(6L, "Boston");
	        	put(7L, "Hartford");	        	
	        	put(8L, "Westbury");	        	
	        	put(9L, "Montauk");
	        	put(10L, "Hamptons");
	        	put(11L, "West Hampton");
	        };
	    };
	    
	    @SuppressWarnings("serial")	    
		Map<Long, String> countries = new HashMap<Long, String>() {
	        {
	        	
	        	put(1L, "USA");
	        	put(2L, "JAM");
	        	put(3L, "TRI");
	        	put(4L, "BDS");
	        	put(5L, "CAN");
	        	put(6L, "ENG");
	        	put(7L, "GER");	        	
	        	put(8L, "ITA");	        	
	        	put(9L, "ARG");
	        	put(10L, "BRA");
	        	put(11L, "CUB");
	        };
	    };
		
	    for (int count=0; count < Constants.RESEARCH_STUDENTS_DATASET_SIZE; count++){

	    	double age = Math.ceil(Math.random() * 18);
		    double grade = Math.ceil(Math.random() * 100); 
		    double line1 = Math.ceil(Math.random() * 100);
		    double sex = Math.ceil(Math.random() * 1);
		    double zip = Math.ceil(Math.random() * 99999);
		    double street = Math.ceil(Math.random() * streets.size());
		    double city = Math.ceil(Math.random() * cities.size());
		    double state = Math.ceil(Math.random() * states.size());
		    double country = Math.ceil(Math.random() * countries.size());
		    double fname = Math.ceil(Math.random() * firstnames.size());
		    double lname = Math.ceil(Math.random() * lastnames.size());

	    	address = new Address(toString(line1), toString(line1).concat(" ").concat((String)streets.get((long)street)), Constants.BLANK, (String)cities.get((long)city),
	    			(String)states.get((long)state), toString(zip),(String)countries.get((long)country));
	    	
	    	student = new Student((String)firstnames.get((long)fname).concat(" ").concat((String)lastnames.get((long)lname)), address, toString(age), (sex==1)? "M":"F", toString(grade));
			repository.insertStudent(student);
			
	    }
	}

	private String toString(double d){
		return new Double(d).toString();
	}

	@SuppressWarnings("unused")	
	private Long toLong(double d){
		return (long)d;
	}
	
	@SuppressWarnings("unused")
	private String toString(float f){
		return new Float(f).toString();
	}
	
	public boolean insertAll() {
		
		initData();
		return true;
	}
	
	public Document getEntity(String studentid) {
    	
		return repository.findStudentById(studentid);
	}

	public StudentRepository getEntityRepo(){
		
		return repository;
	}
	
	public void setEntityRepo(AbstractRepository repo) {
		
		this.repository = (StudentRepository)repo;
	}	
	
	public List<Document> getAllEntities(){
		
		return repository.findStudentCollection();
	}

	public boolean hasEntities() {

		return (repository.findStudentCollection().isEmpty());
	}	
	
	public boolean addEntity(BaseEntity entity) {
	
		return repository.insertStudent((Student)entity);
	}

	public boolean removeEntity(BaseEntity entity) {
		
		return repository.removeStudentById(((Student)entity).getStudentId());
	}

	public boolean removeEntityById(String studentId) {
		
		return repository.removeStudentById(studentId);
	}
		
	public boolean updateEntity(BaseEntity entity) {
		
		return repository.updateStudentInCollection((Student)entity);
	}

	public boolean removeAll(){

		return repository.dropStudentCollection();
	}
	
}



