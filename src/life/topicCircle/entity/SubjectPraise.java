package life.topicCircle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_subjectPraise")
@Component(value="subjectPraise")
public class SubjectPraise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subjectPraiseid;
	private Integer phone;
	private Integer subjectid;
	public Integer getSubjectPraiseid() {
		return subjectPraiseid;
	}
	public void setSubjectPraiseid(Integer subjectPraiseid) {
		this.subjectPraiseid = subjectPraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
}
