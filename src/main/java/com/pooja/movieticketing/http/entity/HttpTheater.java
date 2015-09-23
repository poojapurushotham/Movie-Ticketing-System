package com.pooja.movieticketing.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.Theater;

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
	
	//required by framework
	protected HttpTheater() {}

	public HttpTheater(Theater theater) {
		this.id=theater.getTheaterId();
		this.theaterName=theater.getTheaterName();
		this.screens=theater.getScreens();
		this.zip=theater.getZip();
	}
	
}
