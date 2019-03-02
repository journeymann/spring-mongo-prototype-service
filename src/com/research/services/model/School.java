package com.research.services.model;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import org.springframework.data.mongodb.core.index.Indexed;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.research.services.constants.Constants;
import com.research.services.model.ext.Address;

@SuppressWarnings("serial")
@Document(collection = "model")
public class School extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String schoolId;
	private String name;
	private Address address;
	private String district;
	
	ObjectMapper mapper = new ObjectMapper();

	public School(){
		
	}

	public School(String pschoolid, String pname, String pnumber, String pstreet, String pcity, String pstate, String pzip, String pcountry,
			String pdistrict) {
		super();
		this.schoolId = pschoolid;
		this.name = pname;
		
		this.address = new Address( pnumber, pstreet, Constants.BLANK, pcity, pstate, pzip, pcountry);
		
		this.district = pdistrict;
	}

	public School(String pname, Address paddress, String pdistrict) {
		super();
		this.name = pname;
		this.address = paddress;
		this.district = pdistrict;
	}
	
	
	public String getSchoolId() {
		return schoolId;
	}
	
	@JsonSetter("id")	
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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

	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
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
