package life.taoyu.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import persionalCenter.entity.User;

@Component(value = "order")
public class Order implements Serializable{// 买的订单实体类

	private Integer order_id;// 表ID
	private String order_status;// 订单状态
	private String order_date;// 订单日期
	private String address;// 买家地址
	private String name;// 买家姓名
	private String phone;// 买家手机号
	private String total;//订单总计
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}



	private User user;
	// （UO_id 外键维护卖家用户表）
	
	private Set<OrderItems> setorderitems=new HashSet<OrderItems>();//使用set集合表示OrderItems类
	
	public Set<OrderItems> getSetorderitems() {
		return setorderitems;
	}
	public void setSetorderitems(Set<OrderItems> setorderitems) {
		this.setorderitems = setorderitems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_status=" + order_status + ", order_date=" + order_date
				+ ", address=" + address + ", name=" + name + ", phone=" + phone + ", total=" + total + 
				 "]";
	}
}
