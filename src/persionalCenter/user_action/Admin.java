package persionalCenter.user_action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.modeldriver.Gimgs;
import life.taoyu.modeldriver.Ugoods;
import life.taoyu.service.TaoyuService;
import zzu.util.Panduanstr;

@Transactional
@Component(value = "admin")
@Scope(value = "prototype")
public class Admin extends ActionSupport {
	
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;
	HttpServletRequest request = ServletActionContext.getRequest();

	HttpSession session = request.getSession();
	List<Ugoods> list = new ArrayList<Ugoods>();
	String[] str;

	public String[] getStr() {
		return str;
	}

	public List<Ugoods> getList() {
		return list;
	}

	// 登陆
	@Override
	public String execute() throws Exception {
	String	account = request.getParameter("account");
	String	password = request.getParameter("password");

		String info = null;
		if (account != null && password != null && account.equals("admin") && password.equals("123")) {
			session.setAttribute("admin", "已登录");
			info = "success";
			try {
				Thread thread = Thread.currentThread();
				thread.sleep(4000);// 暂停4秒后程序继续执行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			addActionError("账号或密码有误");
			info = "input";
		}
		System.out.println(account + ":" + password);
		System.out.println("管理员登陆:" + info);

		return info;
	}

	// 退出
	public String loginout() {
		session.setAttribute("admin", "未登录");
		session.invalidate();
		System.out.println("session已销毁");
		addActionError("成功退出");
		return "loginout";
	}
	
	//搜索商品
	public String search(){
		Panduanstr p=new Panduanstr();
		String SearchGoods=request.getParameter("SearchGoods");
		System.out.println("查询的关键字:"+SearchGoods);
		request.getSession().setAttribute("SearchGoods", SearchGoods);
		if(SearchGoods!=null){
			String sql="from Goods where Gsearch like '%"+SearchGoods+"%'";
			
			list=taoyuService.AdminQueryGoods(sql);
			
			for (Ugoods ugoods : list) {
				List<Gimgs> g=new ArrayList<Gimgs>();
				 str=p.fenli(ugoods.getGoods().getGimage());
				for(int i=0;i<str.length;i++){
					Gimgs Gimg=new Gimgs();
					Gimg.setImg(str[i]);
					g.add(Gimg);
				}
					ugoods.setGimgs(g);
				      
			}
			System.out.println("查出的商品和用户信息:"+list);
		}
			
		return "returnUgoods";
	}
	//再次查询
	public String research(String SearchGoods){
		Panduanstr p=new Panduanstr();
		System.out.println("再次查询的关键字:"+SearchGoods);
		if(SearchGoods!=null){
			String sql="from Goods where Gsearch like '%"+SearchGoods+"%'";
			
			list=taoyuService.AdminQueryGoods(sql);
			
			for (Ugoods ugoods : list) {
				List<Gimgs> g=new ArrayList<Gimgs>();
				str=p.fenli(ugoods.getGoods().getGimage());
				for(int i=0;i<str.length;i++){
					Gimgs Gimg=new Gimgs();
					Gimg.setImg(str[i]);
					g.add(Gimg);
				}
				ugoods.setGimgs(g);
				
			}
			System.out.println("查出的商品和用户信息:"+list);
		}
		
		return "returnUgoods";
	}
	//删除商品
	public String deletegoods() throws ServletException, IOException{
		
		String goodsid=request.getParameter("deletegoods")+"";
		
		System.out.println("要删除的商品ID："+goodsid);
		//删除商品
		if(goodsid !=null){
		boolean b=taoyuService.deletegoods(goodsid);
		if(b){
			System.out.println("ID为:"+goodsid+"的商品删除成功");
		}else{System.out.println("ID为:"+goodsid+"的商品删除失败");}
		}
		//查询
		 value=request.getSession().getAttribute("SearchGoods")+"";

		 research(value);

		return "returnUgoods";
	}
	String value,SearchGoods;
	public String getSearchGoods() {
		return SearchGoods;
	}

	public void setSearchGoods(String searchGoods) {
		SearchGoods = searchGoods;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
