package com.zzu.service;

import java.util.List;

import com.zzu.entity.SocietyNews;

public interface SocietyNewsService {
	 void save(SocietyNews societyNews);
	 List<SocietyNews> query(String News_Id);
}
