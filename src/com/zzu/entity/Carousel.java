package com.zzu.entity;

import org.springframework.stereotype.Component;

@Component(value="carousel")
public class Carousel {

	private String imgUrl;
	public Integer getCarouselid() {
		return carouselid;
	}
	public void setCarouselid(Integer carouselid) {
		this.carouselid = carouselid;
	}
	private Integer carouselid;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
