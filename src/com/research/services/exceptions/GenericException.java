package com.research.services.exceptions;

/**
 * Super class for all entity classes.
 * @author cgordon
 *
 */
import com.research.services.constants.Constants;

public class GenericException extends Exception{

	private static final long serialVersionUID = -7917057687580777621L;
	protected short code = Constants.STATUS_INTERNAL_SERVER_ERROR;
	protected String message;
	
	public GenericException(Short cde){
		super(Constants.errorCodeMap.get(cde).getMessage());
		code = cde;
	}
	
	public GenericException(String msg){
		super(msg);		
	}

	public GenericException(Short cde, String msg){
		code = cde;
		message = msg;
	}
	
	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
