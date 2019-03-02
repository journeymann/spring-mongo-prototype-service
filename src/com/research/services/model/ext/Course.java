package com.research.services.model.ext;

import org.springframework.data.annotation.Id;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.research.services.model.BaseEntity;

@SuppressWarnings("serial")
@Document(collection = "model")
public class Course extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String courseId;
	private String code;
	private String name;
	private String date;
	private String semester;
	private String instructor;

	ObjectMapper mapper = new ObjectMapper();
	
	public Course(){
		
	}
	
	public Course( String pcode, String pname, String pdate, String psemester, String pinstructor) {
		super();
		this.code = pcode;
		this.name = pname;
		this.date = pdate;
		this.semester = psemester;
		this.instructor = pinstructor;
	}

	public Course(String pcourseId, String pcode, String pname, String pdate, String psemester, String pinstructor) {
		super();
		this.courseId = pcourseId;
		this.code = pcode;
		this.name = pname;
		this.date = pdate;
		this.semester = psemester;
		this.instructor = pinstructor;
	}
	
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	@JsonSetter("id")	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}
}

