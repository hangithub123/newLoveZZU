package life.taoyu.modeldriver;

import java.util.List;

import org.springframework.stereotype.Component;

import life.taoyu.entity.Order;
import life.taoyu.entity.OrderItems;
@Component(value="OrderAndItems")
public class OrderAndItems {

	private String Action;
	private String SessionID;
	private Order OrderData;
	private String StrOrderData;
	private String orderID;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	private List<String> StrOrderItemsData;
	private List<OrderItems> OrderItemsData;
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public Order getOrderData() {
		return OrderData;
	}
	public void setOrderData(Order orderData) {
		OrderData = orderData;
	}
	public List<OrderItems> getOrderItemsData() {
		return OrderItemsData;
	}
	
	public String getStrOrderData() {
		return StrOrderData;
	}
	public void setStrOrderData(String strOrderData) {
		StrOrderData = strOrderData;
	}
	public List<String> getStrOrderItemsData() {
		return StrOrderItemsData;
	}
	public void setStrOrderItemsData(List<String> strOrderItemsData) {
		StrOrderItemsData = strOrderItemsData;
	}
	public void setOrderItemsData(List<OrderItems> orderItemsData) {
		OrderItemsData = orderItemsData;
	}
	@Override
	public String toString() {
		return "OrderAndItems [Action=" + Action + ", SessionID=" + SessionID + ", OrderData=" + OrderData
				+ ", orderID=" + orderID + ", OrderItemsData=" + OrderItemsData + "]";
	}




}
