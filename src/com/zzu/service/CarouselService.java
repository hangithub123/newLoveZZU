package com.zzu.service;

import java.util.List;

import com.zzu.entity.Carousel;

public interface CarouselService {
	 void save(Carousel carousel);
	 List<Carousel> findAll();
}
