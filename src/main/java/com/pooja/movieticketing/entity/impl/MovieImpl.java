package com.pooja.movieticketing.entity.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Showtime;

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
	
	@Column(name="reviews")
	private String reviews;
	
	@Column(name="movie_length")
	private double movie_length;
	
	/*
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "movie_showtime", targetEntity=ScreenImpl.class)
	@JoinTable(name="movie_showtime", joinColumns = { @JoinColumn(name = "movie_idmovie", nullable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "bank_location_idbank_location", nullable = false) })
	private List<Screen> screens;
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "movie_showtime", targetEntity=TheaterImpl.class)	
	private List<Theater> theaters;
	*/
	
	@OneToMany(mappedBy = "movie", targetEntity=ShowtimeImpl.class, cascade=CascadeType.ALL)	
    private List<Showtime> showtimes;
	
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
		return movie_length;
	}
	public void setLength(double length) {
		this.movie_length = length;
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
				+ releaseDate + ", rating=" + rating + ", length=" + movie_length
				+ "]";
	}
	
}
