package com.zzu.entity;

import org.springframework.stereotype.Component;

@Component(value="navigation")
public class Navigation {

	private String imgUrl;
	private Integer navigationid;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Integer getNavigationid() {
		return navigationid;
	}
	public void setNavigationid(Integer navigationid) {
		this.navigationid = navigationid;
	}
}
