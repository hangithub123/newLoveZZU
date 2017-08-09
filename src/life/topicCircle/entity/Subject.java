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
@Table(name="t_subject")
@Component(value="subject")
public class Subject {

	@Id
	@Column(name="subject_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subjectId;
	private String title;
	private String content;
	private String phone;
	private String urlImg;
	private Integer praiseNumber;
	private Integer contentNumber;
	private Date date;
	
	@OneToMany(targetEntity=Topic.class , cascade=CascadeType.REFRESH , fetch=FetchType.EAGER)
	@JoinColumn(name="subject_id" , referencedColumnName="subject_id")
	private Set<Topic> topic = new HashSet<>();
	
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getUrlImg() {
		return urlImg;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

    public Set<Topic> getTopic() {
		return topic;
	}

	public void setTopic(Set<Topic> topic) {
		this.topic = topic;
	}
	
	
	
}
