package life.topicCircle.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Results;

import life.topicCircle.entity.Subject;
import life.topicCircle.service.SubjectService;
@Transactional
@Component(value="subjectAction")
@Scope(value="prototype")
public class SubjectAction extends ActionSupport  {
	
	@Resource(name="subject")
	private Subject subject;
	@Resource(name="results")
	private Results results;
	
	@Resource(name="subjectServiceImpl")
	private SubjectService subjectService;
	private String jsonObject=null;
	public String execute() throws Exception {
		
	try{
	HttpServletRequest request =ServletActionContext.getRequest();
	request.setCharacterEncoding("UTF-8");
	String page=request.getParameter("page");
	
	int intpage= Integer.parseInt(page);
	List all =(ArrayList)subjectService.findByPage( intpage, 6);
	
	results.setResults(all);
	results.setNumber(intpage);
	//Type type = new TypeToken<List<TreeHole>>(){}.getType();
	Gson gson =new Gson();
	//String jsonObject= gson.toJson(all, type);
	
	jsonObject= gson.toJson(results);
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		HttpServletResponse response= ServletActionContext.getResponse();	
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	         PrintWriter out=response.getWriter();
	    	 out.println(jsonObject);
	    	 System.out.println(jsonObject);
	    	 out.flush();
	    	 out.close();
	}
	
		return NONE;
	}
	public String Select() throws Exception {
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String phone=request.getParameter("phone");
		int intphone= Integer.parseInt(phone);
		String sql="select t from Subject t where t.phone=? ";
		System.out.println("--------");
		List all=subjectService.query(sql,new Integer[]{intphone});
		
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
}
