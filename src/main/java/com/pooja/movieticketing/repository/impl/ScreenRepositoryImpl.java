package com.pooja.movieticketing.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pooja.movieticketing.repository.ScreenRepository;
import com.pooja.movieticketing.entity.Screen;
import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.entity.impl.ScreenImpl;
import com.pooja.movieticketing.entity.impl.TheaterImpl;

@Repository
public class ScreenRepositoryImpl implements ScreenRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addScreen(Screen screen) {
		return (int) this.sessionFactory.getCurrentSession().save(screen);		
	}

	@Override
	public Screen getScreen(int screenId) {
		return (Screen) this.sessionFactory.getCurrentSession().get(ScreenImpl.class, screenId);
	}

	@Override
	public void updateScreen(Screen screen) {
		this.sessionFactory.getCurrentSession().update(screen);
	}
	
	@Override
	public void deleteScreen(int screenId) {
		this.sessionFactory.getCurrentSession().delete(this.getScreen(screenId));
	}
	
	@Override
	public List<Screen> getScreenList(int theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("theater_idtheater", theaterId));	
		List<Screen> screens = crit.list();
		return screens;
	}

}