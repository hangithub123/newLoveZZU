package com.zzu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.CarouselDao;
import com.zzu.entity.Carousel;
import com.zzu.service.CarouselService;

@Transactional
@Service(value="carouselServiceImpl")
public class CarouselServiceImpl implements CarouselService{

	@Resource(name="carouselDaoHibernate5")
	private CarouselDao carouselDao;
	public void save(Carousel carousel){
		carouselDao.save(carousel);
	}
	public List<Carousel> findAll(){
		return carouselDao.findAll(Carousel.class);
	}
}
