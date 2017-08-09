package persionalCenter.confessionWall.action;

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

import persionalCenter.confessionWall.entity.BareHeart;
import persionalCenter.confessionWall.service.BareHeartService;

@Transactional
@Component(value="bareHeartAction")
@Scope(value="prototype")
public class BareHeartAction extends ActionSupport{

	
	@Resource(name="bareHeartServiceImpl")
	private BareHeartService bareHeartService;
	@Resource(name="bareHeart")
	private BareHeart bareHeart;
	@Resource(name="results")
	private Results results;
	private String jsonObject =null;
	public String execute() throws Exception {
		try{
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String page=request.getParameter("page");
		int intpage= Integer.parseInt(page);
		List al =(ArrayList)bareHeartService.findByPage(intpage, 6);
		results.setResults(al);
		results.setNumber(intpage);
		Gson gson =new Gson();
	    jsonObject= gson.toJson(results);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			HttpServletResponse response= ServletActionContext.getResponse();	
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "text/html;charset=UTF-8");
		         PrintWriter out=response.getWriter();
		    	 out.println(jsonObject);
		    	 out.flush();
		    	 out.close();
		}
		return NONE;
	}
}
