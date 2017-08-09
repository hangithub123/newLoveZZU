package life.taoyu.modeldriver;

import life.taoyu.entity.Comments_L1;
import persionalCenter.entity.UserInfo;

public class Ucomments {

	private UserInfo userinfo;
	private Comments_L1 comments_L1;
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Comments_L1 getComments_L1() {
		return comments_L1;
	}
	public void setComments_L1(Comments_L1 comments_L1) {
		this.comments_L1 = comments_L1;
	}
}
