package life.topicCircle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_topicContentPraise")
@Component(value="topicContentPraise")
public class TopicContentPraise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer topicContentPraiseid;
	private Integer phone;
	private Integer topicContentid;
	
	public Integer getTopicContentPraiseid() {
		return topicContentPraiseid;
	}
	public void setTopicContentPraiseid(Integer topicContentPraiseid) {
		this.topicContentPraiseid = topicContentPraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getTopicContentid() {
		return topicContentid;
	}
	public void setTopicContentid(Integer topicContentid) {
		this.topicContentid = topicContentid;
	}
	
}
