package com.zzu.service;

import java.io.Serializable;
import java.util.List;

import com.zzu.entity.Society;

public interface SocietyService {
	 Society get(Serializable id);
	 void update(Society society);
	 void save(Society society);
	 List<Society> query(Integer values);
	 List<Society> findAll();
	 List<Society> findByPage(final int pageNo, final int pageSize );
}
