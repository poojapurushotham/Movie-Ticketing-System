package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import  org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.repository.ShowtimeRepository;
import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Showtime;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.ShowtimeImpl;

@Repository
public class ShowtimeRepositoryImpl implements ShowtimeRepository {

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Showtime> getShowtimes(int movieId, int theaterId, int screenId) {
		@SuppressWarnings("unchecked")
		List<Showtime> showtimes = sessionFactory.getCurrentSession().createQuery("from ShowtimeImpl where movieId=" + movieId + "and theaterId=" + theaterId + "and screenId=" + screenId ).list(); 
		return showtimes;	
	}
	
	@Override
	public Showtime getShowtime(int showtimeId) {
		return (Showtime) sessionFactory.getCurrentSession().get(ShowtimeImpl.class,showtimeId);
	}

	@Override
	public void updateShowtime(Showtime showtime) {
		this.sessionFactory.getCurrentSession().update(showtime);
		
	}

	@Override
	public List<Theater> viewAllTheatersforMovie(int movieId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowtimeImpl.class)
				.add(Restrictions.eq("movie_showtime_movie_idmovie", movieId));	
		@SuppressWarnings("unchecked")
		List<Theater> theaters = crit.list();
		return theaters;
	}


	@Override
	public List<Movie> viewAllMoviesInTheater(int theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowtimeImpl.class)
				.add(Restrictions.eq("movie_showtime_theater_idtheater", theaterId));	
		@SuppressWarnings("unchecked")
		List<Movie> movies = crit.list();
		return movies;
	}



}