package com.pooja.movieticketing.enitity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Screen;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.enitity.Ticket;

@Entity
@Table(name="movie")
public class MovieImpl implements Movie{
	
	@Id
	@Column(name="idmovie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="language")
	private String language;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="synopsis")
	private String synopsis;
	
	@Column(name="cast")
	private String cast;
	
	@Column(name="director")
	private String director;
	
	@Column(name="prod_house")
	private String productionHouse;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="length")
	private double length;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "screen_has_movie", targetEntity=ScreenImpl.class)	
	private List<Screen> screens;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "theater_has_movie", targetEntity=TheaterImpl.class)	
	private List<Theater> theaters;
	
	@OneToMany(mappedBy = "ticket", targetEntity=TicketImpl.class, cascade=CascadeType.ALL)	
    private List<Ticket> tickets;
	
	//constructor 
	public MovieImpl() {}
	
	public int getMovieId() {
		return movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSynopsis() {
		return synopsis;
	}	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public String getProductionHouse() {
		return productionHouse;
	}
	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}

	@Override
	public String toString() {
		return "MovieImpl [movieId=" + movieId + ", movieName=" + movieName
				+ ", language=" + language + ", genre=" + genre + ", synopsis="
				+ synopsis + ", cast=" + cast + ", director=" + director
				+ ", productionHouse=" + productionHouse + ", releaseDate="
				+ releaseDate + ", rating=" + rating + ", length=" + length
				+ "]";
	}
	
}
