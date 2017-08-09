package zzu.util;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Jsondemo {

	
	public static void main(String[] args) {
		
		
		User2 user2=new User2();
		user2.setName("韩伟其");
		user2.setAge(20);
		user2.setSex("男");


		Goods goods=new Goods();
		goods.setGname("java经典讲义");
		goods.setGimage(("http://localhost:8080/zzu"));
		goods.setGprice("60");
		
		UGoods ugoods=new UGoods();
		ugoods.setUser2(user2);
		ugoods.setGoods(goods);
		
		
		User2 user3=new User2();
		user3.setName("刘德华");
		user3.setAge(40);
		user3.setSex("男");
	
		Goods goods2=new Goods();
		goods2.setGname("PHP经典讲义");
		goods2.setGimage(("http://localhost:8080/zzu"));
		goods2.setGprice("50");
		
		UGoods ugoods2=new UGoods();
		ugoods2.setUser2(user3);
		ugoods2.setGoods(goods2);
		

		List<UGoods> list=new ArrayList<UGoods>();
	       list.add(ugoods);
          list.add(ugoods2);
		 JSONArray values = JSONArray.fromObject(list);  
		 
		 JSONObject json=new JSONObject();
		 json.put("result", "result");
		 json.put("values", values);
		  
		 System.out.println(json);
		// System.out.println(json.get("values"));
		 JSONArray result=(JSONArray) json.get("values");
		 System.out.println(result);
		 
		 try{
			 System.out.println(result.size()+"条信息");
		 for(int i=0;i<result.size();i++){
			 
			 JSONObject jsonobject=new JSONObject();
		          jsonobject=result.getJSONObject(i);
		          System.out.println("总的json信息：。。。。"+jsonobject);
			 System.out.println("对象goods属性值:"+jsonobject.get("goods"));
			 System.out.println("对象user2属性值:"+jsonobject.get("user2"));
			 
			
			 
			 //获取ugoods对象中 user和goods数据
			 JSONObject jsonobject3=jsonobject.getJSONObject("goods");
			// System.out.println(jsonobject3);
			System.out.println(jsonobject3.get("gname")+jsonobject3.getString("gimage")+jsonobject3.getString("gprice"));
			 JSONObject goodsobject3=jsonobject.getJSONObject("user2");
				System.out.println(goodsobject3.get("name")+goodsobject3.getString("age")+goodsobject3.getString("sex"));
			
		 
		 }}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
