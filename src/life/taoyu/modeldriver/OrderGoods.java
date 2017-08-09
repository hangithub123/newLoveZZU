package life.taoyu.modeldriver;

import life.taoyu.entity.Goods;
import life.taoyu.entity.Order;

public class OrderGoods {

	private Order order;
	private Goods goods;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "OrderGoods [order=" + order + ", goods=" + goods + ", count=" + count + "]";
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
