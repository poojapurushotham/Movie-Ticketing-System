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
@XmlRootElement(name = "customer")
public class HttpMovie {
	
	@XmlElement
	public int id;
	
	@XmlElement//(name="foo")
	public String movieName;
	
	@XmlElement
	public String language;
	
	@XmlElement
	public String genre;
	
	@XmlElement
	public double rating;
	
	@Override
	public String toString() {
		return "HttpMovie [id=" + id + ", movieName=" + movieName
				+ ", language=" + language + ", genre=" + genre + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((rating == 0) ? 0 : Double.valueOf(rating).hashCode());
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
		HttpMovie other = (HttpMovie) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (rating != (other.rating))
			return false;
		
		return true;
	}
	
}
