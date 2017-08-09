package life.treeHole.entity;

import java.util.HashSet;

import java.util.Set;



import org.springframework.stereotype.Component;


@Component(value="treeHole")
public class TreeHole {

	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer treeHoleid;
	private String phoneTreeHole;
	
	private Integer praiseNumber;
	private Integer commentNumber;
	private String content;
	
	//@OneToMany(targetEntity=TreeHoleComment.class , cascade=CascadeType.REFRESH , fetch=FetchType.LAZY)
	//@JoinColumn(name="treeHoleid" , referencedColumnName="treeHoleid")

	private Set<TreeHoleComment> treeHoleComment = new HashSet<>();
	
	
	public Integer getTreeHoleid() {
		return treeHoleid;
	}
	
	public void setTreeHoleid(Integer treeHoleid) {
		this.treeHoleid = treeHoleid;
	}

	
	public String getPhoneTreeHole() {
		return phoneTreeHole;
	}

	public void setPhoneTreeHole(String phoneTreeHole) {
		this.phoneTreeHole = phoneTreeHole;
	}

	public Integer getPraiseNumber() {
		return praiseNumber;
	}
	public void setPraiseNumber(Integer praiseNumber) {
		this.praiseNumber = praiseNumber;
	}
	public Integer getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<TreeHoleComment> getTreeHoleComment() {
		return treeHoleComment;
	}
	public void setTreeHoleComment(Set<TreeHoleComment> treeHoleComment) {
		this.treeHoleComment = treeHoleComment;
	}
}
