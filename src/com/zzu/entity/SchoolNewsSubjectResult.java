package com.zzu.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Entity
@Table(name="t_schoolNewsSubjectResult")
@Component(value="schoolNewsSubjectResult")
public class SchoolNewsSubjectResult {
	@Id @Column(name="News_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer News_Id;
    private String News_Title;
    private String Author;
    private String Subject;
    private String Time;
    private String ReadNumber;
    private String LikesNumber;
    private String CommentNumber;
	public String getNews_Title() {
		return News_Title;
	}
	public void setNews_Title(String news_Title) {
		News_Title = news_Title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getReadNumber() {
		return ReadNumber;
	}
	public void setReadNumber(String readNumber) {
		ReadNumber = readNumber;
	}
	public String getLikesNumber() {
		return LikesNumber;
	}
	public void setLikesNumber(String likesNumber) {
		LikesNumber = likesNumber;
	}
	public String getCommentNumber() {
		return CommentNumber;
	}
	public void setCommentNumber(String commentNumber) {
		CommentNumber = commentNumber;
	}
	public Integer getNews_Id() {
		return News_Id;
	}
	public void setNews_Id(Integer news_Id) {
		News_Id = news_Id;
	}
	
}
