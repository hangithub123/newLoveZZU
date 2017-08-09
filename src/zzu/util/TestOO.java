package zzu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import life.taoyu.entity.Order;
import life.taoyu.entity.OrderItems;
import life.taoyu.modeldriver.OrderAndItems;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestOO {

	
	public static OrderAndItems GetJsonObject(){
		Order order = new Order();
		
		order.setName("韩伟其");
		order.setAddress("郑州");
		order.setPhone("15639066181");
		

		OrderItems oi = new OrderItems();
		oi.setGoods_id(61);
		oi.setCount(1);

		OrderItems oiw = new OrderItems();
		oiw.setGoods_id(62);
		oiw.setCount(2);

		List<OrderItems> oilist=new ArrayList<OrderItems>();
		oilist.add(oi);
		oilist.add(oiw);
		
		OrderAndItems OAI=new OrderAndItems();
		OAI.setAction("生成订单");
		OAI.setSessionID("36620df2-d1c0-4a23-b41d-3e46415a4784");
		OAI.setOrderData(order);
		OAI.setOrderItemsData(oilist);
		
		
	
		
	
		return OAI;}
	
//	public static void main(String[] args) {
//
//		Order order = new Order();
//		order.setBuyerOrseller("buyer");
//		order.setName("韩伟其");
//		order.setAddress("郑大");
//		order.setPhone("110");
//		order.setOrder_status("待付款");
//
//		OrderItems oi = new OrderItems();
//		oi.setGoods_id(1);
//		oi.setCount(1);
//
//		OrderItems oiw = new OrderItems();
//		oiw.setGoods_id(2);
//		oiw.setCount(2);
//
//		List<OrderItems> oilist=new ArrayList<OrderItems>();
//		oilist.add(oi);
//		oilist.add(oiw);
//		
//		OrderAndItems OAI=new OrderAndItems();
//		OAI.setAction("生成订单");
//		OAI.setSessionID("f801ea81-65cc-443f-94e7-5282cf00c1ea");
//		OAI.setOrderData(order);
//		OAI.setOrderItemsData(oilist);
//		
//		Getjson getjson=new Getjson();
//		JSONObject JsonOrder=getjson.getjsonobject(OAI);
//	
//		
//		System.out.println(JsonOrder);
//		
//		JSONObject jorder=JsonOrder.getJSONObject("orderdata");
//		System.out.println(jorder);
//		 
//		JSONArray JsonArray=JsonOrder.getJSONArray("orderitemsdata");
//		System.out.println(JsonArray);
//		
//		for(int i=0;i<JsonArray.size();i++){
//			JSONObject oiobject=JsonArray.getJSONObject(i);
//			System.out.println(oiobject.get("count")+","+oiobject.get("goods_id"));
//		}
//		
//		for(int i=0;i<JsonArray.size();i++){
//		OrderItems items = (OrderItems) JSONObject.toBean(JsonArray.getJSONObject(i),OrderItems.class);
//		System.out.println(items);
//		}
		
//		List<UGoods> list = new ArrayList<UGoods>();
//		list.add(ugoods);
//		list.add(ugoods2);
//		JSONArray values = JSONArray.fromObject(list);
//
//		JSONObject json = new JSONObject();
//		json.put("result", "result");
//		json.put("values", values);
//
//		System.out.println(json);
//		// System.out.println(json.get("values"));
//		JSONArray result = (JSONArray) json.get("values");
//		System.out.println(result);
//
//		try {
//			System.out.println(result.size() + "条信息");
//			for (int i = 0; i < result.size(); i++) {
//
//				JSONObject jsonobject = new JSONObject();
//				jsonobject = result.getJSONObject(i);
//				System.out.println("总的json信息：。。。。" + jsonobject);
//				System.out.println("对象goods属性值:" + jsonobject.get("goods"));
//				System.out.println("对象user2属性值:" + jsonobject.get("user2"));
//
//				// 获取ugoods对象中 user和goods数据
//				JSONObject jsonobject3 = jsonobject.getJSONObject("goods");
//				// System.out.println(jsonobject3);
//				System.out.println(
//						jsonobject3.get("gname") + jsonobject3.getString("gimage") + jsonobject3.getString("gprice"));
//				JSONObject goodsobject3 = jsonobject.getJSONObject("user2");
//				System.out.println(
//						goodsobject3.get("name") + goodsobject3.getString("age") + goodsobject3.getString("sex"));
//
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	//}

}
