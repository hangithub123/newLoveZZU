package life.topicCircle.entity;

import java.sql.Date;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="t_topic")
@Component(value="topic")
public class Topic {

	@Id
	@Column(name="topic_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer topicId;
	private String phone;
	private String content;
	private Integer praiseNumber;
	private Integer contentNumber;
	private String urlImg;
	private Date date;
	
	
	@OneToMany(targetEntity=TopicContent.class , cascade=CascadeType.REFRESH , fetch=FetchType.EAGER)
	@JoinColumn(name="topic_id" , referencedColumnName="topic_id")
	private Set<TopicContent> topicContent = new HashSet<>();
	
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(Integer praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	public Integer getContentNumber() {
		return contentNumber;
	}

	public void setContentNumber(Integer contentNumber) {
		this.contentNumber = contentNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Set<TopicContent> getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(Set<TopicContent> topicContent) {
		this.topicContent = topicContent;
	}
	
}
