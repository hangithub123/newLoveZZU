package persionalCenter.confessionWall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_bareHeartPraise")
@Component(value="bareHeartPraise")
public class BareHeartPraise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bareHeartPraiseid;
	private Integer phone;
	private Integer bareHeartid;
	public Integer getBareHeartPraiseid() {
		return bareHeartPraiseid;
	}
	public void setBareHeartPraiseid(Integer bareHeartPraiseid) {
		this.bareHeartPraiseid = bareHeartPraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getBareHeartid() {
		return bareHeartid;
	}
	public void setBareHeartid(Integer bareHeartid) {
		this.bareHeartid = bareHeartid;
	}
	
}
