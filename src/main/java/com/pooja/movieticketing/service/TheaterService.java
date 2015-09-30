package com.pooja.movieticketing.service;

import java.util.List;

import com.pooja.movieticketing.entity.Theater;

public interface TheaterService {
	public Theater addTheater(Theater theater);
	public Theater getTheater(int theaterId);
	public List<Theater> getTheater(long zip);
	public void updateTheater(Theater theater);
	public void deleteTheater(int theaterId);
}
