package life.treeHole.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_treeHoleCommentPraise")
@Component(value="treeHoleCommentPraise")
public class TreeHoleCommentPraise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer treeHoleCommentPraiseid;
	private Integer phone;
	private Integer treeHoleCommentid;
	
	public Integer getTreeHoleCommentPraiseid() {
		return treeHoleCommentPraiseid;
	}
	public void setTreeHoleCommentPraiseid(Integer treeHoleCommentPraiseid) {
		this.treeHoleCommentPraiseid = treeHoleCommentPraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getTreeHoleCommentid() {
		return treeHoleCommentid;
	}
	public void setTreeHoleCommentid(Integer treeHoleCommentid) {
		this.treeHoleCommentid = treeHoleCommentid;
	}
	
	
	
}
