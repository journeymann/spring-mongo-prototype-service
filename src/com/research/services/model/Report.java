/**
 * 
 */
package com.research.services.model;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.research.services.model.ext.Grade;

@SuppressWarnings("serial")
@Document(collection = "model")
public class Report extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String reportId;
	private String label;
	private String semester;
	private List<Grade> grades;
	
	ObjectMapper mapper = new ObjectMapper();

	public Report(){
		
	}
	
	public Report(String reportId, String plabel, String psemester, List<Grade> pgrades) {
		super();
		this.reportId = reportId;
		this.label = plabel;
		this.semester = psemester;
		this.grades = pgrades;
	}
	
	/**
	 * @return the reportId
	 */
	public String getReportId() {
		return reportId;
	}

	/**
	 * @param reportId the reportId to set
	 */
	@JsonSetter("id")	
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
	 * @return the grades
	 */
	public List<Grade> getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	/**
	 * @param grades the grades to set
	 */
	@JsonIgnore
	public void addGrade(Grade grade) {
		if(!this.grades.isEmpty()) this.grades.add(grade);
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

