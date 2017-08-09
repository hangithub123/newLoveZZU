package life.treeHole.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="t_treeHolePraise")
@Component(value="treeHolePraise")
public class TreeHolePraise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer treeHolePraiseid;
	private Integer phone;
	private Integer treeHoleid;
	
	
	
	public Integer getTreeHoleid() {
		return treeHoleid;
	}
	public void setTreeHoleid(Integer treeHoleid) {
		this.treeHoleid = treeHoleid;
	}
	//@ManyToOne(targetEntity=TreeHole.class , cascade=CascadeType.REFRESH , fetch=FetchType.EAGER)
	//@JoinColumn(name="treeHoleid" , referencedColumnName="treeHoleid")
	//private TreeHole treeHole;
	public Integer getTreeHolePraiseid() {
		return treeHolePraiseid;
	}
	public void setTreeHolePraiseid(Integer treeHolePraiseid) {
		this.treeHolePraiseid = treeHolePraiseid;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	
}
