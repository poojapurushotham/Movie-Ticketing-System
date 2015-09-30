package com.pooja.movieticketing.service.exception;

/**
 * Root of our exception heirarchy
 * @author pooja
 *
 */
@SuppressWarnings("serial")
public class MovieTicketingException extends RuntimeException {
	private ErrorCode errorCode;

	public MovieTicketingException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public MovieTicketingException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
