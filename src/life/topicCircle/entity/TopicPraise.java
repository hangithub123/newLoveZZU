package life.topicCircle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_topicPraise")
@Component(value="topicPraise")
public class TopicPraise {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer topicPraiseid;
	private Integer phone;
	private Integer topicid;
	
	public Integer getTopicPraiseid() {
		return topicPraiseid;
	}
	public void setTopicPraiseid(Integer topicPraiseid) {
		this.topicPraiseid = topicPraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	
}
