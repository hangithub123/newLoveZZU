package life.treeHole.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import life.treeHole.entity.TreeHole;
import life.treeHole.service.TreeHoleService;
@Controller(value="addTreeHoleAction")
@Scope(value="prototype")
public class AddTreeHoleAction extends ActionSupport {

	
	@Resource(name="treeHole")
	private TreeHole treeHole;
	@Resource(name="treeHoleServiceImpl")
	private TreeHoleService treeHoleService;
	
	private String content;
	
	private String phoneTreeHole;
	private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
		treeHole.setPhoneTreeHole(phoneTreeHole);
		treeHole.setCommentNumber(0);
		treeHole.setPraiseNumber(0);
		treeHole.setContent(content);
		treeHoleService.save(treeHole);
		isSuccessful=true;
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
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoneTreeHole() {
		return phoneTreeHole;
	}

	public void setPhoneTreeHole(String phoneTreeHole) {
		this.phoneTreeHole = phoneTreeHole;
	}

	

	
	
}
