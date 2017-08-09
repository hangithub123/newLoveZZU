package life.treeHole.action;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import life.treeHole.entity.TreeHole;
import life.treeHole.entity.TreeHolePraise;
import life.treeHole.service.TreeHolePraiseService;
import life.treeHole.service.TreeHoleService;

@Controller(value="addTreeHolePraiseAction")
@Scope(value="prototype")
public class AddTreeHolePraiseAction extends ActionSupport{

	
	@Resource(name="treeHolePraise")
	private TreeHolePraise treeHolePraise;
	
	@Resource(name="treeHolePraiseServiceImpl")
	private TreeHolePraiseService treeHolePraiseService;
	
	@Resource(name="treeHole")
	private TreeHole treeHole;
	
	@Resource(name="treeHoleServiceImpl")
	private TreeHoleService treeHoleService;
	
	private Integer phone;
	private Integer treeHoleid;
	private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
		String sql="select t from TreeHolePraise t where t.phone=? and t.treeHoleid=?";
		List l=treeHolePraiseService.query(sql,new Integer[]{phone,treeHoleid});
		if(l.isEmpty() == true){
			treeHolePraise.setPhone(phone);
			treeHolePraise.setTreeHoleid(treeHoleid);
			treeHolePraiseService.save(treeHolePraise);
			TreeHole t = treeHoleService.get(TreeHole.class, treeHolePraise.getTreeHoleid());
			System.out.println(t.getPraiseNumber());
			int i =t.getPraiseNumber()+1;
			t.setPraiseNumber(i);
			treeHoleService.update(t);
		}
		isSuccessful = true ;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HttpServletResponse response= ServletActionContext.getResponse();	
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "text/html;charset=UTF-8");
		         PrintWriter out=response.getWriter();
		    	 out.println(isSuccessful);
		    	
		    	 out.flush();
		    	 out.close();
		}
		
		return NONE;
	}
	
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getTreeHoleid() {
		return treeHoleid;
	}

	public void setTreeHoleid(Integer treeHoleid) {
		this.treeHoleid = treeHoleid;
	}

	
}
