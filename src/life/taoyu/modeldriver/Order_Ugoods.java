package life.taoyu.modeldriver;

import java.util.List;

import life.taoyu.entity.Order;

public class Order_Ugoods {

	private Order orderdata;
	private List<Ugoods> ugoods;
	public Order getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(Order orderdata) {
		this.orderdata = orderdata;
	}
	public List<Ugoods> getUgoods() {
		return ugoods;
	}
	public void setUgoods(List<Ugoods> ugoods) {
		this.ugoods = ugoods;
	}
	@Override
	public String toString() {
		return "Order_Ugoods [orderdata=" + orderdata + ", ugoods=" + ugoods + "]";
	}

	
}
