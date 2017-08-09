package persionalCenter.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import life.taoyu.entity.Cart;
import life.taoyu.entity.Goods;
import life.taoyu.entity.Order;



@Service(value="User")
public class User {

	//用户属性
	private Integer uid;
	private String phone;
	private String password;
	private String account;
	private String verification_code; //验证码
	private String SessionID;//身份ID
	private String SessionIDDate;//身份ID日期

	

	private Set<UserInfo> setuserinfo=new HashSet<UserInfo>();//使用set集合表示UserInfo
	private Set<Goods> setgoods=new HashSet<Goods>();//使用set集合表示Goods类
	private Set<Order> setorder=new HashSet<Order>();//使用set集合表示Order类
	private Set<Cart> setcart=new HashSet<Cart>();//使用set集合表示Cart类

	
	public Set<Order> getSetorder() {
		return setorder;
	}
	public void setSetorder(Set<Order> setorder) {
		this.setorder = setorder;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSessionIDDate() {
		return SessionIDDate;
	}
	public void setSessionIDDate(String sessionIDDate) {
		SessionIDDate = sessionIDDate;
	}
	
	


	public Set<Cart> getSetcart() {
		return setcart;
	}
	public void setSetcart(Set<Cart> setcart) {
		this.setcart = setcart;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}



		public Set<Goods> getSetgoods() {
		return setgoods;
	}
	public void setSetgoods(Set<Goods> setgoods) {
		this.setgoods = setgoods;
	}
	public Set<UserInfo> getSetuserinfo() {
		return setuserinfo;
	}
	public void setSetuserinfo(Set<UserInfo> setuserinfo) {
		this.setuserinfo = setuserinfo;
	}
	public String getVerification_code() {
		return verification_code;
	}
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pssword) {
		this.password = pssword;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User[phone:"+phone+",password:"+password+"]";
	}
	
}
