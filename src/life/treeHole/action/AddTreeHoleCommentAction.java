package life.treeHole.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import life.treeHole.entity.TreeHole;
import life.treeHole.entity.TreeHoleComment;
import life.treeHole.service.TreeHoleCommentService;
import life.treeHole.service.TreeHoleService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value="addTreeHoleCommentAction")
@Scope(value="prototype")
public class AddTreeHoleCommentAction extends ActionSupport {

	@Resource(name="treeHoleComment")
	private TreeHoleComment treeHoleComment;
	
	@Resource(name="treeHole")
	private TreeHole treeHole;
	
	@Resource(name="treeHoleCommentServiceImpl")
	private TreeHoleCommentService treeHoleCommentService;
	
	@Resource(name="treeHoleServiceImpl")
	private TreeHoleService treeHoleService;
	
	private String phone;
	private String comment;
	
	private Integer treeHoleid;
	
	private boolean isSuccessful=false;
	
	@Override
	public String execute() throws Exception {
		
		try{
		treeHole = treeHoleService.get(TreeHole.class, treeHoleid);
		System.out.println(treeHole.getCommentNumber());
		System.out.println(treeHole.getPraiseNumber());
		if(treeHole.getCommentNumber()==null){
			treeHole.setCommentNumber(0);
		}else{
			int i=treeHole.getCommentNumber()+1;
			treeHole.setCommentNumber(i);
		}
		treeHoleComment.setPraiseCommentNumber(0);
		treeHoleComment.setPhone(phone);
		treeHoleComment.setComment(comment);	
		treeHole.getTreeHoleComment().add(treeHoleComment);
		treeHoleComment.setTreeHole(treeHole);
		treeHoleCommentService.save(treeHoleComment);
		treeHoleService.update(treeHole);
		isSuccessful = true; 
		}catch(Exception c){
			c.printStackTrace();
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
	public String Select() throws Exception {
		int intphone= Integer.parseInt(phone);
		String sql="select t from TreeHoleComment t where t.phone=? ";
		System.out.println("--------");
		List all=treeHoleCommentService.query(sql,new Integer[]{intphone});
		
		Gson gson =new Gson();

		String jsonObject= gson.toJson(all);
		HttpServletResponse response= ServletActionContext.getResponse();	
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	         PrintWriter out=response.getWriter();
	    	 out.println(jsonObject);
	    	 System.out.println(jsonObject);
	    	 out.flush();
	    	 out.close();
		return NONE;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getTreeHoleid() {
		return treeHoleid;
	}

	public void setTreeHoleid(Integer treeHoleid) {
		this.treeHoleid = treeHoleid;
	}
}
