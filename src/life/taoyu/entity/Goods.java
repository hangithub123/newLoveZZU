package life.taoyu.entity;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import persionalCenter.entity.User;
@Component(value="goods")
//商品实体类
public class Goods {

	private Integer Goods_id ;//商品id
	private String Gtype;// 商品分类
	private String Gname;//  商品名称
	private String Gcampus;// 校区
	private String Gdescribe;//商品描述
	private String Gprice;// 商品价格
	private String Gimage;//商品图片
	
	private Integer Gcomments;//评论数
	private String Gsearch;//用于搜索的字段
	private String Gdate;//商品日期
    
	private Set<Comments_L1> setcomments_L1=new HashSet<Comments_L1>();//使用set集合表示Comments_L1类

	public Set<Comments_L1> getSetcomments_L1() {
		return setcomments_L1;
	}
	public void setSetcomments_L1(Set<Comments_L1> setcomments_L1) {
		this.setcomments_L1 = setcomments_L1;
	}
	

  
	




	public Integer getGcomments() {
		return Gcomments;
	}
	public void setGcomments(Integer gcomments) {
		Gcomments = gcomments;
	}







	private User user;
    private String SessionID;
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public String getGimage() {
		return Gimage;
	}
	public void setGimage(String gimage) {
		Gimage = gimage;
	}
	

	
	public String getGdate() {
		return Gdate;
	}
	public void setGdate(String gdate) {
		Gdate = gdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public Integer getGoods_id() {
		return Goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		Goods_id = goods_id;
	}
	public String getGtype() {
		return Gtype;
	}
	public void setGtype(String gtype) {
		Gtype = gtype;
	}
	public String getGname() {
		return Gname;
	}
	public void setGname(String gname) {
		Gname = gname;
	}

	public String getGcampus() {
		return Gcampus;
	}
	public void setGcampus(String gcampus) {
		Gcampus = gcampus;
	}
	public String getGdescribe() {
		return Gdescribe;
	}
	public void setGdescribe(String gdescribe) {
		Gdescribe = gdescribe;
	}
	public String getGprice() {
		return Gprice;
	}
	public void setGprice(String gprice) {
		Gprice = gprice;
	}
	
	public String getGsearch() {
		return Gsearch;
	}
	public void setGsearch(String gsearch) {
		Gsearch = gsearch;
	}
	@Override
	public String toString() {
		return "Goods [Goods_id=" + Goods_id + ", Gtype=" + Gtype + ", Gname=" + Gname + ", Gcampus=" + Gcampus
				+ ", Gdescribe=" + Gdescribe + ", Gprice=" + Gprice + ", Gimage=" + Gimage + 
				", Gcomments=" + Gcomments + ", Gsearch=" + Gsearch + ", Gdate=" + Gdate + "]";
	}


	
}
