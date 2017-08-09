package life.taoyu.action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import life.taoyu.entity.Goods;
import life.taoyu.entity.Order;
import life.taoyu.entity.OrderItems;
import life.taoyu.modeldriver.OrderAndItems;
import life.taoyu.modeldriver.OrderGoods;
import life.taoyu.modeldriver.Order_Ugoods;
import life.taoyu.service.TaoyuService;
import zzu.util.Getjson;
import zzu.util.Returndata;
import zzu.util.Sort;

@Component(value ="OrderAction")
@Scope(value = "prototype")
public class OrderAction extends ActionSupport implements ModelDriven<OrderAndItems> {

	/**
	 * 订单操作
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderAndItems OAI =new OrderAndItems();
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	
	
	private Getjson getJsonArray=new Getjson();
	@Override
	public OrderAndItems getModel() {
		// TODO Auto-generated method stub
		return OAI;
	}
	

	

	boolean Successful = false;
    HttpServletRequest request=ServletActionContext.getRequest();

	@Override
	public String execute() throws Exception {
		//把安卓端传来的String类型Gson字符串转为对象，并添加到模型驱动里
		if(OAI.getStrOrderData()!=null && !OAI.getStrOrderData().isEmpty()){
		  Gson gson = new Gson();  
		    String json = OAI.getStrOrderData();  	  
		    // json转为简单Bean  
		    Order order = gson.fromJson(json, Order.class);  
		    System.out.println("order:"+order);  
		    OAI.setOrderData(order);//设置订单对象
		    System.out.println("订单项list:"+OAI.getStrOrderItemsData());
		    List<OrderItems> orlist=new ArrayList<OrderItems>();
		    for (String orderItems : OAI.getStrOrderItemsData()) {
		    	  Gson gson2 = new Gson();  
				    String json2 = orderItems;  				  
				    // json转为简单Bean  
				    OrderItems orderitems = gson2.fromJson(json2, OrderItems.class); 
				    
				    orlist.add(orderitems);
			}
		    OAI.setOrderItemsData(orlist);
		}

		System.out.println(OAI);
		
		 if(OAI.getAction()==null){ System.err.println("订单操作action为空"); return null;}
		 switch (OAI.getAction()) {
		case "生成订单":
                    Successful= taoyuService.savaorder(OAI);
			        Returndata.returnboolean(Successful);
			break;
		case "查询买家订单":
			List<Order_Ugoods> OUG = taoyuService.queryorder(OAI);
			List<Order_Ugoods> OUG2=	Sort.sortByStatus(OUG);//按照待付款/已付款优先的原则
			Returndata.returndata(getJsonArray.getjsonarray(OUG2, "查询买家订单"));
			break;
		case "付款"://付款和删除订单都没有使用SessionID验证一遍用户。
			Integer id=Integer.valueOf(OAI.getOrderID());
			 System.out.println(id);
			 Order o=new Order();
			 o.setOrder_id(id);
			 o.setOrder_status("已付款");
			Successful= taoyuService.updateOrderStatus(o);
			 Returndata.returnboolean(Successful);
			break;
		case "删除订单":
			Integer id2=Integer.valueOf(OAI.getOrderID());
			 System.out.println(id2);
			 Successful= taoyuService.deleteOrder(id2);
			 Returndata.returnboolean(Successful);
			break;
		case "查询卖家订单":
			List<OrderGoods> OGlist=taoyuService.querySellerOrder(OAI.getSessionID());
			List<OrderGoods> OG2=	Sort.sortByStatus2(OGlist);//按照待付款/已付款优先的原则
			Returndata.returndata(getJsonArray.getjsonarray(OG2, "查询卖家订单"));
			break;
		
		default:
			System.err.println("订单操作action为空串");
			 Returndata.returnboolean(false);
			break;
		}
		 
		return null;
	}
	 
	
	
	
}
