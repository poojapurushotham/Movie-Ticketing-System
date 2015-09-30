package com.pooja.movieticketing.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.movieticketing.entity.Theater;
import com.pooja.movieticketing.repository.TheaterRepository;
import com.pooja.movieticketing.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	@Transactional
	@Override
	public Theater addTheater(Theater theater) {
		int id = theaterRepository.addTheater(theater);
		return getTheater(id);
	}

	@Transactional
	@Override
	public Theater getTheater(int theaterId) {
		return theaterRepository.getTheater(theaterId);		
	}

	@Transactional
	@Override
	public List<Theater> getTheater(long zip) {
		return theaterRepository.searchTheater(zip);
	}
	
	@Transactional
	@Override
	public void updateTheater(Theater theater) {
		theaterRepository.updateTheater(theater);		
	}

	@Transactional
	@Override
	public void deleteTheater(int theaterId) {
		theaterRepository.deleteTheater(theaterId);
	}
	
}
