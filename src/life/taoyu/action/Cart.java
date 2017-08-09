package life.taoyu.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.modeldriver.CGoods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONObject;
import zzu.util.Getjson;
import zzu.util.Returndata;
@Component(value = "cartAction")
@Scope(value = "prototype")
public class Cart extends ActionSupport{

	/**
	 * 购物车
	 */
	private static final long serialVersionUID = 1L;
	private String SessionID;
	private String action=null;
	private String goods_id=null;
	private String count="1";
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
@Override
public String execute() throws Exception {
	boolean isSuccessful=false;
	String[] cartinfo=new String[3];
	cartinfo[0]=SessionID;cartinfo[1]=goods_id;cartinfo[2]=count;
	JSONObject goods = new JSONObject();
	Getjson array = new Getjson();
	
	if(SessionID ==null && action ==null){System.out.println("操作购物车商品所需条件有为空的属性");return "false";}
	if(action.equals("添加") && goods_id !=null){
		//添加商品到购物车
		isSuccessful=taoyuService.AddGoodsToCart(cartinfo);
		Returndata.returnboolean(isSuccessful);//返回布尔值
	}else if(action.equals("查询")){
		//查询购物车中商品
		List<CGoods> cglist=taoyuService.queryCart(cartinfo);
		goods = array.getjsonarray(cglist, action);
		Returndata.returndata(goods);//返回数据
	}else if(action.equals("删除") && goods_id !=null){
		//删除购物车内商品
		isSuccessful=taoyuService.DeleteGoodsFromCart(cartinfo);
		Returndata.returnboolean(isSuccessful);
	}

	
	return null;
}









//属性注入

public String getSessionID() {
	return SessionID;
}
public void setSessionID(String sessionID) {
	SessionID = sessionID;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public String getGoods_id() {
	return goods_id;
}
public void setGoods_id(String goods_id) {
	this.goods_id = goods_id;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}



}
