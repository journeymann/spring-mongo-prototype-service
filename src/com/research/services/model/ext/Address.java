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
public class Address extends BaseEntity{
	@Id
	@Indexed(unique=true)
	private String addressId;
	private String number;
	private String line1;
	private String line2;	
	private String city;
	private String state;
	private String zip;
	private String country;

	ObjectMapper mapper = new ObjectMapper();
	
	public Address(){
		
	}

	public Address(String pnumber, String pline1, String pline2, String pcity, String pstate, String pzip,
			String pcountry) {
		super();
		this.number = pnumber;
		this.line1 = pline1;
		this.line2 = pline2;
		this.city = pcity;
		this.state = pstate;
		this.zip = pzip;
		this.country = pcountry;
	}
	
	public Address(String paddressId, String pnumber, String pline1, String pline2, String pcity, String pstate, String pzip,
			String pcountry) {
		super();
		this.addressId = paddressId;
		this.number = pnumber;
		this.line1 = pline1;
		this.line2 = pline2;
		this.city = pcity;
		this.state = pstate;
		this.zip = pzip;
		this.country = pcountry;
	}

	/**
	 * @return the addressId
	 */
	public String getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	@JsonSetter("id")	
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}

	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}

	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
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
