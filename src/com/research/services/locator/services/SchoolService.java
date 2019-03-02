package com.research.services.locator.services;
import java.util.HashMap;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.research.services.model.School;
import com.research.services.model.ext.Address;
import com.research.services.constants.Constants;
import com.research.services.exceptions.ServiceException;
import com.research.services.locator.ResourceInterface;
import com.research.services.locator.ServiceLocator;
import com.research.services.locator.repositories.AbstractRepository;
import com.research.services.locator.repositories.SchoolRepository;
import com.research.services.model.BaseEntity;

public class SchoolService extends AbstractService implements ResourceInterface{
	private SchoolRepository repository;
	private String servicename = Constants.NAMING_SERVICE_SCHOOLS; 
	
	public void execute(){
		  System.out.println(String.format("Executing %s", servicename));
	}

	@Override
	public String getName() {
		 return servicename;
	}	
	
	public SchoolService() throws ServiceException, Exception{
		super();
		this.setEntityRepo((SchoolRepository)ServiceLocator.getResource(servicename));
	}

	public SchoolService(SchoolRepository repo) {
		super();
		this.setEntityRepo(repo);
	}
	
	public void initData(){ 

		repository.dropSchoolCollection();
		
		School school;
		Address address;
		
		@SuppressWarnings("serial")
		Map<Long, String> schools = new HashMap<Long, String>() {
	        {
	        	put(1L, "Salve Regina Catholic");
	        	put(2L, "PS 102");
	        	put(3L, "Wilborough High");
	        	put(4L, "PS 154 Annex");
	        	put(5L, "Bedford High");
	        	put(6L, "Arthur Ash High School");
	        	put(7L, "Albert Einstein Tech");	        	
	        	put(8L, "Katherine Kennedy High");	        	
	    	    put(9L, "Saint Thomas Moore High");	        			
	        	
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
		Map<Long, String> counties = new HashMap<Long, String>() {
	        {
	        	
	        	put(1L, "Kings");
	        	put(2L, "Broward");
	        	put(3L, "Prince William");
	        	put(4L, "Woodbridge");
	        	put(5L, "Queens");
	        	put(6L, "Prince George");
	        	put(7L, "Westborough");	        	
	        	put(8L, "Longsville");	        	
	        	put(9L, "Tri-county");
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
	    
		
	    for (int count=0; count < Constants.RESEARCH_SCHOOLS_DATASET_SIZE; count++){

		    double line1 = Math.ceil(Math.random() * 100);		    
		    double zip = Math.ceil(Math.random() * 99999);
		    double street = Math.ceil(Math.random() * streets.size());
		    double city = Math.ceil(Math.random() * cities.size());
		    double state = Math.ceil(Math.random() * states.size());
		    double country = Math.ceil(Math.random() * countries.size());
		    double county = Math.ceil(Math.random() * counties.size());
		    double sname = Math.ceil(Math.random() * schools.size());

	    	address = new Address(toString(line1), toString(line1).concat(" ").concat((String)streets.get((long)street)), Constants.BLANK, (String)cities.get((long)city),
	    			(String)states.get((long)state), toString(zip),(String)countries.get((long)country));

	    	school = new School((String)schools.get((long)sname), address, (String)counties.get((long)county));
	    	
			repository.insertSchool(school);
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

	public Document getEntity(String schoolid) {
		
    	return Document.parse(repository.findSchoolById(schoolid).toString());
	}

	public SchoolRepository getEntityRepo(){
		return repository;
	}
	
	public void setEntityRepo(AbstractRepository repo) {
		this.repository = (SchoolRepository)repo;
	}	
	
	public List<Document> getAllEntities(){
		return repository.findSchoolCollection();
	}

	
	public boolean hasEntities() {
		return (repository.findSchoolCollection().isEmpty());
	}	
	
	public boolean addEntity(BaseEntity entity) {
	
		return repository.insertSchool((School)entity);
	}

	public boolean removeEntity(BaseEntity entity) {
		
		return repository.removeSchoolById(((School)entity).getSchoolId());
	}

	public boolean removeEntityById(String schoolId) {
		
		return repository.removeSchoolById(schoolId);
	}
		
	public boolean updateEntity(BaseEntity entity) {
		
		return repository.updateSchoolInCollection((School)entity);
	}

	public boolean removeAll(){
		return repository.dropSchoolCollection();
	}
}
