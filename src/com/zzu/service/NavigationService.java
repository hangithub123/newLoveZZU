package com.zzu.service;

import java.util.List;

import com.zzu.entity.Navigation;

public interface NavigationService {
	 void save(Navigation navigation);
	 List<Navigation> findAll();
}
