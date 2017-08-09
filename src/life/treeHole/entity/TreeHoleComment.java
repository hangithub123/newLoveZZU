package life.treeHole.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component(value="treeHoleComment")
public class TreeHoleComment {
	
	private Integer treeHoleCommentid;
	private String phone;
	private String comment;
	private Integer praiseCommentNumber;
	
	transient  private  TreeHole treeHole;
	
	public Integer getTreeHoleCommentid() {
		return treeHoleCommentid;
	}
	public void setTreeHoleCommentid(Integer treeHoleCommentid) {
		this.treeHoleCommentid = treeHoleCommentid;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public TreeHole getTreeHole() {
		return treeHole;
	}
	public void setTreeHole(TreeHole treeHole) {
		this.treeHole = treeHole;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getPraiseCommentNumber() {
		return praiseCommentNumber;
	}
	public void setPraiseCommentNumber(Integer praiseCommentNumber) {
		this.praiseCommentNumber = praiseCommentNumber;
	}
	

}
