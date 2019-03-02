package com.research.services.constants;
/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
public class Status {
	
	private String code;
	private String message;
	
	public Status(){};
	
	public Status(String ce, String msg){
		code = ce;
		message = msg;
	};
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
