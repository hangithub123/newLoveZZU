package life.taoyu.modeldriver;

import life.taoyu.entity.Comments_L2;
import persionalCenter.entity.UserInfo;

public class UComments_L2 {

	private UserInfo userinfo;
	private Comments_L2 comments_l2;
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Comments_L2 getComments_l2() {
		return comments_l2;
	}
	public void setComments_l2(Comments_L2 comments_l2) {
		this.comments_l2 = comments_l2;
	}
	
}
