package com.research.services.model;

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
import com.research.services.model.ext.Address;

@SuppressWarnings("serial")
@Document(collection = "model")
public class Student extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String studentId;
	private String name;
	private Address address;
	private String age;
	private String gender;

	ObjectMapper mapper = new ObjectMapper();
	
	public Student(){
		
	}
	
	public Student(String pname, String pnumber, String pline1, String pline2, String pcity, String pstate, String pzip,
			String pcountry, String page,  String pgender, String pgrade) {
		super();
		this.name = pname;
		
		this.address = new Address( pnumber, pline1, pline2, pcity, pstate, pzip, pcountry);

		this.age = page;
		this.gender = pgender;
	}

	public Student(String pstudentid, String pname, String pnumber, String pline1, String pline2, String pcity, String pstate, String pzip,
			String pcountry, String page,  String pgender, String pgrade) {
		super();
		this.studentId = pstudentid;
		this.name = pname;
		
		this.address = new Address( pnumber, pline1, pline2, pcity, pstate, pzip, pcountry);

		this.age = page;
		this.gender = pgender;
	}

	public Student(String pname, Address paddress, String page,  String pgender, String pgrade) {
		super();
		this.name = pname;
		this.address = paddress;
		this.age = page;
		this.gender = pgender;
	}

	public Student(String pstudentid,String pname, Address paddress, String page,  String pgender, String pgrade) {
		super();
		this.studentId = pstudentid;		
		this.name = pname;
		this.address = paddress;
		this.age = page;
		this.gender = pgender;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	@JsonSetter("id")	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
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
