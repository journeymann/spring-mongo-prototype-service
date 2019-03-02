package com.research.services.constants;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Constants {

	public static final String NAMING_SERVICE_SCHOOLS = "schools";
	public static final String NAMING_SERVICE_STUDENTS = "students";
	public static final String NAMING_REPOSIT_SCHOOLS = "repo/schools";
	public static final String NAMING_REPOSIT_STUDENTS = "repo/students";
	
	public static final String BLANK = "";
	
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String ERROR = "error";
	public static final String WARN = "warn";	
	
	public static final int RESEARCH_STUDENTS_DATASET_SIZE = 1000000;
	public static final int RESEARCH_SCHOOLS_DATASET_SIZE = 1000;
	
	public static final int MAX_SCHOOLS = 20;
	public static final int MIN_SCHOOL_ID = 1001;
	public static final int MAX_STUDENTS = 20;
	public static final int MIN_STUDENTS_ID = 1000001;
	
	public static final short STATUS_OK = (short)200;
	public static final short STATUS_CREATED = (short)201;
	public static final short STATUS_NO_CONTENT = (short)204;
	public static final short STATUS_BAD_REQUEST = (short)400;
	public static final short STATUS_UNAUTHORIZED = (short)401;
	public static final short STATUS_FORBIDDEN = (short)403;
	public static final short STATUS_NOT_FOUND = (short)404;
	public static final short STATUS_METHOD_NOT_ALLOWED = (short)405;
	public static final short STATUS_CONFLICT = (short)409;
	public static final short STATUS_INTERNAL_SERVER_ERROR = (short)500;
	public static final short STATUS_RESOURCE_NOT_FOUND = (short)800;
	
	@SuppressWarnings("serial")
	public static Map<Short, Status> errorCodeMap = new HashMap<Short, Status>() {
        {
            put(STATUS_OK, new Status("OK", "General success status code. This is the most common code. Used to indicate success."));
            put(STATUS_CREATED, new Status("CREATED", "Successful creation occurred (via either POST or PUT). Set the Location header to contain a link to the newly-created resource (on POST). Response body content may or may not be present."));
            put(STATUS_NO_CONTENT, new Status("NO CONTENT", "Indicates success but nothing is in the response body, often used for DELETE and PUT operations."));
            put(STATUS_BAD_REQUEST, new Status("BAD REQUEST", "General error for when fulfilling the request would cause an invalid state. Domain validation errors, missing data, etc. are some examples."));
            put(STATUS_UNAUTHORIZED, new Status("UNAUTHORIZED", "Error code response for missing or invalid authentication token."));
            put(STATUS_FORBIDDEN, new Status("FORBIDDEN", "Error code for when the user is not authorized to perform the operation or the resource is unavailable for some reason (e.g. time constraints, etc.)."));
            put(STATUS_NOT_FOUND, new Status("NOT FOUND", "Used when the requested resource is not found, whether it doesn't exist or if there was a 401 or 403 that, for security reasons, the service wants to mask."));
            put(STATUS_METHOD_NOT_ALLOWED, new Status("METHOD NOT ALLOWED", "Used to indicate that the requested URL exists, but the requested HTTP method is not applicable. For example, POST /users/12345 where the API doesn't support creation of resources this way (with a provided ID). The Allow HTTP header must be set when returning a 405 to indicate the HTTP methods that are supported. In the previous case, the header would look like Allow: GET, PUT, DELETE"));
            put(STATUS_CONFLICT, new Status("CONFLICT", "Whenever a resource conflict would be caused by fulfilling the request. Duplicate entries, such as trying to create two customers with the same information, and deleting root objects when cascade-delete is not supported are a couple of examples."));
            put(STATUS_INTERNAL_SERVER_ERROR, new Status("INTERNAL SERVER ERROR", "Never return this intentionally. The general catch-all error when the server-side throws an exception. Use this only for errors that the consumer cannot address from their end."));
            put(STATUS_RESOURCE_NOT_FOUND, new Status("SERVICE NOT FOUND", "Custom error used when the requested controller service is not found."));
        };
    };
	
	public static final Set<String> resourceTypes = new HashSet<String>(Arrays.asList(NAMING_SERVICE_SCHOOLS,NAMING_SERVICE_STUDENTS,NAMING_REPOSIT_SCHOOLS,NAMING_REPOSIT_STUDENTS));
    
	/**
	 *  Declare class final and constructor private to defeat instantiation and extension
	 */
	private Constants(){}
	
}
