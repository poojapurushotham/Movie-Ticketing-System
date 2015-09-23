package com.pooja.movieticketing.http;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * To unmarshall an error response
 * @author pooja
 *
 */
@XmlRootElement(name = "error")
public class HttpError {
	@XmlElement
	public int status;
	
	@XmlElement
	public String code;
	
	@XmlElement
	public String message;
	
	@XmlElement
	public String debug;

	@Override
	public String toString() {
		return "HttpError [status=" + status + ", code=" + code + ", message="
				+ message + ", debug=" + debug + "]";
	}
	
}
