package life.taoyu.modeldriver;

import org.springframework.stereotype.Component;
@Component(value="CommentsL1_Modeldriver")

public class L1_Comments_Modeldriver {

	private String goods_id;
	private int num=0;
	private String action=null;
	private String sql = null;
	private String values = null;
	private String SessionID=null;
	private String comments=null;
	private String l1_Cid;
	


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getL1_Cid() {
		return l1_Cid;
	}
	public void setL1_Cid(String l1_Cid) {
		this.l1_Cid = l1_Cid;
	}
	@Override
	public String toString() {
		return "L1_Comments_Modeldriver [goods_id=" + goods_id + ", num=" + num + ", action=" + action + ", sql=" + sql
				+ ", values=" + values + ", SessionID=" + SessionID + ", comments=" + comments + ", l1_Cid=" + l1_Cid
				;
	}




	
}
