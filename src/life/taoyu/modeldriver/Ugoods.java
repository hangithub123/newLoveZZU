package life.taoyu.modeldriver;

import java.util.List;

import life.taoyu.entity.Goods;
import persionalCenter.entity.UserInfo;

//建存储用户对象和商品对象的模型 Ugoods
public class Ugoods {

	private UserInfo userinfo;
	private Goods goods;
    private List<Gimgs> gimgs;//用于存放商品图片字符串分离后的名字
	private int count;
	private int total;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Gimgs> getGimgs() {
		return gimgs;
	}
	public void setGimgs(List<Gimgs> gimgs) {
		this.gimgs = gimgs;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Ugoods [userinfo=" + userinfo + ", goods=" + goods + ", gimgs=" + gimgs + ", count=" + count
				+ ", total=" + total + "]";
	}
	
}
