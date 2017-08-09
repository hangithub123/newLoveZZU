package life.taoyu.action;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.entity.Goods;
import life.taoyu.modeldriver.Ugoods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zzu.util.Getjson;
import zzu.util.Returndata;

@Component(value = "querygoodsAction")
@Scope(value = "prototype")

public class Querygoods extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	
	private Getjson getJsonArray=new Getjson();
	private String action = null;// 接收前台发来的分类查询动作
	private int num = 0;// 接受前台发来的数字，用于从第num条数据开始查询

	public void setNum(int num) {
		this.num = num;
	}

	public void setAction(String action) {
		this.action = action;
	}

	String SessionID,goods_id;



	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	@Override
	public String execute() throws Exception {
		String sql = null;

		
		List<Ugoods> list = new ArrayList<Ugoods>();
		
		System.out.println(action + "|||||" + num);
		if (action.equals("学习") || action.equals("娱乐") || action.equals("出行")) {
			sql = "from Goods where Gtype=? order by Goods_id desc";
			list = taoyuService.query(action, num, sql);
			
			System.out.println("分类查询操作");
			// 返回数据
			  Returndata.returndata(getJsonArray.getjsonarray(list, action));
		} 

		else if(action!=null&& action.equals("查询已发布商品")){
			sql="1";//用于是否进行模糊查询
		  List<Goods> GoodsList=taoyuService.QueryPublishedGoods(SessionID);
			System.out.println("查询的发布的商品:"+GoodsList);
			Returndata.returndata(getJsonArray.getjsonarray(GoodsList, action));
			
	  }else if(action !=null && action.equals("删除商品")){
		  sql="1";//用于是否进行模糊查询
		  Boolean Successful=taoyuService.deletePublishedGoods(goods_id);
		  System.out.println("删除已发布商品:"+Successful);
		  Returndata.returnboolean(Successful);
		  
	  }else if (action != null && !action.equals("") && sql==null) {

			sql = "from Goods where Gsearch like ? order by Goods_id desc";
			action = "%" + action + "%";
			list = taoyuService.query(action, num, sql);
			action = "模糊搜索商品";
			
			System.out.println("搜索查询操作");
			// 返回数据
			  Returndata.returndata(getJsonArray.getjsonarray(list, action));
		}
	

		return NONE;
	}
}
