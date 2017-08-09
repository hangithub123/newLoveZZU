package com.zzu.entity;

import org.springframework.stereotype.Component;

@Component(value="society")
public class Society {

	
	private String imgUrl;
	private String title;
	private String time;
	private String readerNumber;
	private Integer News_Id;
	private Integer societyid;
	public Integer getNews_Id() {
		return News_Id;
	}
	public void setNews_Id(Integer news_Id) {
		News_Id = news_Id;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReaderNumber() {
		return readerNumber;
	}
	public void setReaderNumber(String readerNumber) {
		this.readerNumber = readerNumber;
	}
	public Integer getSocietyid() {
		return societyid;
	}
	public void setSocietyid(Integer societyid) {
		this.societyid = societyid;
	}
	
	
}
