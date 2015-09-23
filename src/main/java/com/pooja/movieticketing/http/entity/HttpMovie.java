package com.pooja.movieticketing.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.pooja.movieticketing.entity.Customer;
import com.pooja.movieticketing.entity.Movie;

/**
 * Select fields we want exposed to the REST layer. Separation from business/data layer. 
 * 
 * Note "XML" annotation. The resteasy-jettison implementation converts these to JSON depending on
 * the Accept media type
 * 
 * @author pooja
 *
 */
@XmlRootElement(name = "movie")
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
	
	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie movie) {
		this.id=movie.getMovieId();
		this.movieName=movie.getMovieName();
		this.language=movie.getLanguage();
		this.genre=movie.getGenre();
		this.rating=movie.getRating();
	}
	
}
