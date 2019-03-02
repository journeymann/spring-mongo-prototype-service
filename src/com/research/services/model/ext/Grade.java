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
public class Grade extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String gradeId;
	private String score;
	private String gpa;
	private String date;
	private String courseId;

	ObjectMapper mapper = new ObjectMapper();
	
	public Grade(){
		
	}
	
	public Grade(String pscore, String pgpa, String pdate, String pcourseId) {
		super();
		this.score = pscore;
		this.gpa = pgpa;
		this.date = pdate;
		this.courseId = pcourseId;
	}

	public Grade(String pgradeId, String pscore, String pgpa, String pdate, String pcourseId) {
		super();
		this.gradeId = pgradeId;
		this.score = pscore;
		this.gpa = pgpa;
		this.date = pdate;
		this.courseId = pcourseId;
	}
	
	/**
	 * @return the gradeId
	 */
	public String getGradeId() {
		return gradeId;
	}

	/**
	 * @param gradeId the gradeId to set
	 */
	@JsonSetter("id")	
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the gpa
	 */
	public String getGpa() {
		return gpa;
	}

	/**
	 * @param gpa the gpa to set
	 */
	public void setGpa(String gpa) {
		this.gpa = gpa;
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
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
