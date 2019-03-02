package com.research.services.database;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.text.ParseException;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.research.services.constants.Constants;

@Deprecated
@Component
public class MongoDelegate {
	public static MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
	public static MongoClient mongoClient = new MongoClient( connectionString  );
	public static MongoDatabase db = mongoClient.getDatabase("mydb");
	
	public static FindIterable<Document> get(String table, String column, String value) {
		return db.getCollection(table).find(new Document(column, value));
	}

	public static FindIterable<Document> getAll(String table) {
		return db.getCollection(table).find();
	}

	public static void insert(String table, String column, String value) throws ParseException {	
		
		DataUtils util = new DataUtils(db);
		util.insert(table, column, value);		
	}
	
	public static String insertAll(String table) throws ParseException {
		
		DataUtils util = new DataUtils(db);
		String report = "";
		
		switch(table){
		
			case Constants.NAMING_SERVICE_SCHOOLS:
	
				report = String.format("Total Insert: table: %s - rows: %d \n",
						Constants.NAMING_SERVICE_SCHOOLS, util.insertAll(Constants.NAMING_SERVICE_SCHOOLS));
				
				break;			
				
			case Constants.NAMING_SERVICE_STUDENTS:

				report = String.format("Total Insert: table: %s - rows: %d \n",
						Constants.NAMING_SERVICE_STUDENTS, util.insertAll(Constants.NAMING_SERVICE_STUDENTS));
				
				break;
			
			default:

				report = String.format("Total Insert: table: %s - rows: %d \n",
						table, util.insertAll(table));
				
		}
		
		return report;
	}

	public static DeleteResult delete(String table, String column, String value) {
		DataUtils util = new DataUtils(db);
		
		return util.delete(table, column, value);
		
	}

	public static DeleteResult deleteAll(String table) {
		
		DataUtils util = new DataUtils(db);
		
		return util.deleteAll(table);
	}

	public static UpdateResult update(String table, String column, String value, String newValue) {
		
		DataUtils util = new DataUtils(db);
		
		return util.update(table, column, value, newValue);
	}
	
	
	
}
