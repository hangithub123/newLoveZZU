package zzu.util;

import java.util.LinkedList;
import java.util.List;

import life.taoyu.modeldriver.OrderGoods;
import life.taoyu.modeldriver.Order_Ugoods;

public class Sort {
public static List<Order_Ugoods> sortByStatus(List<Order_Ugoods> OUG){
	//按照未付款，已付款和其他状态排序
	List<Order_Ugoods> frontlist=new LinkedList<>();
	List<Order_Ugoods> Behindlist=new LinkedList<>();
	for (Order_Ugoods oug : OUG) {
		if(oug.getOrderdata().getOrder_status().equals("待付款") || oug.getOrderdata().getOrder_status().equals("已付款")){
			frontlist.add(oug);
		}else{
			Behindlist.add(oug);
		}
		
	}
	
	frontlist.addAll(Behindlist);
	System.out.println("已排序的订单list:"+frontlist);
	return frontlist;
}
public static List<OrderGoods> sortByStatus2(List<OrderGoods> OGlist){
	//按照未付款，已付款和其他状态排序
			List<OrderGoods> frontlist=new LinkedList<>();
			List<OrderGoods> Behindlist=new LinkedList<>();
	for (OrderGoods orderGoods : OGlist) {
		if(orderGoods.getOrder().getOrder_status().equals("待付款") || orderGoods.getOrder().getOrder_status().equals("已付款")){
		frontlist.add(orderGoods);	
		}else{
			Behindlist.add(orderGoods);
		}
	}
		frontlist.addAll(Behindlist);
	return frontlist;
}
}
