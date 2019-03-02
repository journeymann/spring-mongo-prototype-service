package com.research.services.database;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import com.research.services.constants.Constants;

@Deprecated
public class DataUtils {

	MongoDatabase database;
	
	public DataUtils(MongoDatabase db){
		
		database = db;
	}
	
	public String insertAll(String table) throws ParseException {
		
		List<Document> documents = new ArrayList<Document>();
		
		switch(table){
			case Constants.NAMING_SERVICE_SCHOOLS:
				
				documents = insertSchools(table);
				break;
			
			case Constants.NAMING_SERVICE_STUDENTS:
			
				documents = insertStudents(table);
				
				break;				
		default:
			
		
		}
		
		database.getCollection(table).insertMany(documents);
		
		return "Total Insert: " + database.getCollection(table).count(new Document());
		
	}
	
	private List<Document> insertSchools( String table) throws ParseException {
		
		List<Document> documents = new ArrayList<Document>();
		for (int i = Constants.MIN_SCHOOL_ID; i < Constants.MAX_SCHOOLS; i++) {
		    documents.add(new Document("school_id", i++).
		    		append("name", String.format("Salve Regina Catholic (%d)", i)).
		    		append("state", "New York").
		    		append("location", "Brooklyn").
		    		append("street", " 102 Jerome St.").append("zipcode", "11234"));
		    
		    documents.add(new Document("school_id", i++).
		    		append("name", String.format("PS 124", i)).
		    		append("state", "New York").
		    		append("location", "Brooklyn").
		    		append("street", " 100 Pennsylvania Ave.").append("zipcode", "11232"));

		    documents.add(new Document("school_id", i++).
		    		append("name", String.format("Medgar Evans Junior High", i)).
		    		append("state", "New York").
		    		append("location", "Queens").
		    		append("street", " 1021-12 Springfield Ave.").append("zipcode", "13348"));

		    documents.add(new Document("school_id", i++).
		    		append("name", String.format("Fidel Castro Tech", i)).
		    		append("state", "Florida").
		    		append("location", "Ft. Lauderdale").
		    		append("street", "20015 Plantation Drive.").append("zipcode", "33105"));

		    documents.add(new Document("school_id", i++).
		    		append("name", String.format("Holywood Junior High", i)).
		    		append("state", "California").
		    		append("location", "Holywood").
		    		append("street", "20015 Santa Monica Boulevard").append("zipcode", "90210"));
		}
		
		return documents;		
		    
	}

	private List<Document> insertStudents( String table) throws ParseException {
		
		List<Document> documents = new ArrayList<Document>();
		for (int i = Constants.MIN_STUDENTS_ID; i < Constants.MAX_STUDENTS; i++) {
		    documents.add(new Document("student_id", i++).
		    		append("name", String.format("Tom Jones (%d)", i)).
		    		append("state", "New York").
		    		append("location", "Brooklyn").
		    		append("street", " 102 E 101 St.").append("zipcode", "11236"));
		    
		    documents.add(new Document("student_id", i++).
		    		append("name", String.format("Anthony Coore", i)).
		    		append("state", "New York").
		    		append("location", "Brooklyn").
		    		append("street", " 1001 Pennsylvania Ave.").append("zipcode", "11232"));

		    documents.add(new Document("student_id", i++).
		    		append("name", String.format("Samuel Jackson", i)).
		    		append("state", "New York").
		    		append("location", "Queens").
		    		append("street", " 1021-22 Springfield Ave.").append("zipcode", "13348"));

		    documents.add(new Document("student_id", i++).
		    		append("name", String.format("Fidel Castro", i)).
		    		append("state", "Florida").
		    		append("location", "Ft. Lauderdale").
		    		append("street", "20015 E Plantation Boulevard.").append("zipcode", "33105"));

		    documents.add(new Document("student_id", i++).
		    		append("name", String.format("Nickeisha Johnson", i)).
		    		append("state", "California").
		    		append("location", "Holywood").
		    		append("street", "215 Santa Monica Blvd.").append("zipcode", "90210"));
		}
	
		return documents;
		    
	}
	
	
	public DeleteResult delete( String table, String key, String value) {

			return database.getCollection(table).deleteOne(new Document( key, value));
	}

	public DeleteResult deleteAll( String table) {
			return database.getCollection(table).deleteMany(new Document());
	}

	public UpdateResult update( String table, String key, String value, String newValue) {
			return database.getCollection(table).updateOne(new Document(key, value),
					new Document("$set", new Document(key, newValue )).append("$currentDate",
							new Document("lastModified", Boolean.valueOf(true))));
	}
	
	public void insert( String table, String key, String value) {
		database.getCollection(table).insertOne(new Document(key, value).append("$currentDate",
						new Document("lastModified", Boolean.valueOf(true))));
}
	
}
