package com.research.services.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
@Document
@JsonIgnoreProperties(ignoreUnknown=true)
@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {
	//id will be used for storing MongoDelegate _id
    @Id
    private String id;
   
	@JsonIgnore
    public String getId() {
        return id;
    }
	
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
	@JsonIgnore    
    public int hashCode() {
        return (id == null) ? 0 : id.hashCode();
    }
    
    @Override
	@JsonIgnore
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        BaseEntity other = (BaseEntity) obj;
        if (id == null) return other.id == null;
        return id.equals(other.id);
    }
}

