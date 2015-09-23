package com.pooja.movieticketing.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.entity.Movie;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.TheaterImpl;
import com.pooja.movieticketing.repository.MovieRepository;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.impl.TheaterServiceImpl;

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
		this.sessionFactory.getCurrentSession().update(theater);
	}
	
	public void deleteTheater(int theaterId) {
		this.sessionFactory.getCurrentSession().delete(this.getTheater(theaterId));
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getMovieList(int theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterServiceImpl.class)
				.add(Restrictions.eq("theater_has_movie.theater_idtheater", theaterId));		
		List<Movie> movies = crit.list();
		return movies;
	}

	@Override
	public List<Theater> searchTheater(long zip) {
		List<Theater> theaters = new ArrayList<>();
		theaters.addAll(this.sessionFactory.getCurrentSession().get(TheaterImpl.class, zip));
		return null;
	}	
}
