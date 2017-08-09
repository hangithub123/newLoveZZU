package com.zzu.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

@Entity
@Table(name="t_advisory")
@Component(value="advisory")
public class Advisory {
	
	@Id @Column(name="advisoryid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer advisoryid;
	
	private String urlImg;
	private String title;
	
	private Integer New_Id;
/*	
	@OneToOne(targetEntity=SchoolNewsSubjectResult.class)
	// 映射名为News_Id的外键列，参照关联实体对应表的News_Id主键列
	@JoinColumn(name="News_Id"
		, referencedColumnName="News_Id" , unique=true)
	//@Cascade(CascadeType.PERSIST)
	
	private SchoolNewsSubjectResult schoolNewsSubjectResult;
	*/
	
	public String getUrlImg() {
		return urlImg;
	}
	public Integer getNew_Id() {
		return New_Id;
	}
	public void setNew_Id(Integer new_Id) {
		New_Id = new_Id;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAdvisoryid() {
		return advisoryid;
	}
	public void setAdvisoryid(Integer advisoryid) {
		this.advisoryid = advisoryid;
	}
	
}
