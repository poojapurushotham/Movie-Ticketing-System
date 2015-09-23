package com.pooja.movieticketing.service.exception;

/**
 * Root of our exception heirarchy
 * @author pooja
 *
 */
@SuppressWarnings("serial")
public class TBTFException extends RuntimeException {
	private ErrorCode errorCode;

	public TBTFException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public TBTFException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
