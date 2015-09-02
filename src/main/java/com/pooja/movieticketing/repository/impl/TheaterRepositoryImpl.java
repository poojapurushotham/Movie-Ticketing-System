package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.enitity.Movie;
import com.pooja.movieticketing.enitity.Theater;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.TheaterRepository;


@Repository
public class TheaterRepositoryImpl implements TheaterRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	//customer
	public int addTheater(Theater theater) {
		return (int) this.sessionFactory.getCurrentSession().save(theater);
		
	}

	public Theater getTheater(int theaterId) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterId);
	}

	public void updateTheater(Theater theater) {
		this.sessionFactory.getCurrentSession().update(Theater);
	}
	
	public void deleteTheater(int TheaterId) {
		this.sessionFactory.getCurrentSession().delete(this.get(theaterId));
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getMovieList(int theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterServiceImpl.class)
				.add(Restrictions.eq("theater_has_movie.theater_idtheater", theaterId));		
		List<Movie> movies = crit.list();
		return movies;
	}

}
