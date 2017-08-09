package persionalCenter.confessionWall.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_bareHeart")
@Component(value="bareHeart")
public class BareHeart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bareHeartid;
	private String urlImg;
	private String title;
	private Integer praise;
	private Integer commentNumber;
	private String phone;
	
	
	public Integer getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Integer getBareHeartid() {
		return bareHeartid;
	}
	public void setBareHeartid(Integer bareHeartid) {
		this.bareHeartid = bareHeartid;
	}
}
