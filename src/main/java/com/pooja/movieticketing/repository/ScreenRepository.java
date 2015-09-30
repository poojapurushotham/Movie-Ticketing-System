package com.pooja.movieticketing.repository;

import java.util.List;

import com.pooja.movieticketing.entity.Screen;

public interface ScreenRepository {
	
	public int addScreen(Screen screen);

	public Screen getScreen(int screenId);
	
	public void updateScreen(Screen screen);
	
	public void deleteScreen(int screenId);
	
	public List<Screen> getScreenList(int theaterId);
	
}	