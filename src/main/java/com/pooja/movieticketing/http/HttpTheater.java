package com.pooja.movieticketing.http;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author pooja
 *
 */
@XmlRootElement(name = "theater")
public class HttpTheater {
	
	@XmlElement
	public int id;
	
	@XmlElement//(name="foo")
	public String theaterName;
	
	@XmlElement
	public String address;
	
	@XmlElement
	public int screens;
	
	@XmlElement
	public long zip;
	
	@Override
	public String toString() {
		return "HttpTheater [id=" + id + ", theaterName=" + theaterName  + ", screens=" + screens
				+ ", address=" + address + ", zip=" + zip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((theaterName == null) ? 0 : theaterName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (screens ^ (screens >>> 32));
		result = prime * result
				+ ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (zip ^ (zip >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpTheater other = (HttpTheater) obj;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (id != other.id)
			return false;
		if (screens != other.screens)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (zip != other.zip)
			return false;
		
		return true;
	}
	
}
