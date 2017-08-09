package life.treeHole.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.treeHole.entity.TreeHoleComment;
import life.treeHole.entity.TreeHoleCommentPraise;
import life.treeHole.service.TreeHoleCommentPraiseService;
import life.treeHole.service.TreeHoleCommentService;

@Controller(value="addTreeHoleCommentPraiseAction")
@Scope(value="prototype")
public class AddTreeHoleCommentPraiseAction extends ActionSupport{

	@Resource(name="treeHoleCommentPraise")
	private TreeHoleCommentPraise treeHoleCommentPraise;
	
	@Resource(name="treeHoleCommentPraiseServiceImpl")
	private TreeHoleCommentPraiseService treeHoleCommentPraiseService;
	
	@Resource(name="treeHoleComment")
	private TreeHoleComment treeHoleComment;
	
	@Resource(name="treeHoleCommentServiceImpl")
	private TreeHoleCommentService treeHoleCommentService;
	
	private Integer phone;
	private Integer treeHoleCommentid;
    private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
		String sql="select t from TreeHoleCommentPraise t where t.phone=? and t.treeHoleCommentid=?";
		List l=treeHoleCommentPraiseService.query(sql,new Integer[]{phone,treeHoleCommentid});
	  
		if(l.isEmpty()==true){
			treeHoleCommentPraise.setPhone(phone);
			treeHoleCommentPraise.setTreeHoleCommentid(treeHoleCommentid);
			treeHoleCommentPraiseService.save(treeHoleCommentPraise);
			//如果点赞人存在
			TreeHoleComment t = treeHoleCommentService.get(TreeHoleComment.class, treeHoleCommentPraise.getTreeHoleCommentid());
			int i =t.getPraiseCommentNumber()+1;
			t.setPraiseCommentNumber(i);
			treeHoleCommentService.update(t);
		}
		isSuccessful=true;
		}catch(Exception e ){
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

	public Integer getTreeHoleCommentid() {
		return treeHoleCommentid;
	}

	public void setTreeHoleCommentid(Integer treeHoleCommentid) {
		this.treeHoleCommentid = treeHoleCommentid;
	}
}
