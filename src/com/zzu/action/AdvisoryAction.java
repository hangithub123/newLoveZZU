package com.zzu.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.zzu.entity.Advisory;

import com.zzu.entity.Results;
import com.zzu.service.AdvisoryService;

import net.sf.json.JSONObject;

@Transactional
@Component(value="advisoryAction")
@Scope(value="prototype")
public class AdvisoryAction extends ActionSupport{

	//◊¢»Î Ù–‘
	@Resource(name="advisoryServiceImpl")
	private AdvisoryService advisoryService;
	@Resource(name="advisory")
	private Advisory advisory;
	@Resource(name="results")
	private Results results;
	
	public String execute() throws Exception {
	HttpServletRequest request =ServletActionContext.getRequest();
	request.setCharacterEncoding("UTF-8");
	String page=request.getParameter("page");
	int intpage= Integer.parseInt(page);
	
	
	List all =(ArrayList)advisoryService.findByPage( intpage, 6);
	//List al =(ArrayList)advisoryService.findAll();
	//List all=(ArrayList)advisoryService.findAll();
	/*List all = new ArrayList();
	for(Iterator iter = al.iterator(); iter.hasNext();)
    {
		advisory = (Advisory)iter.next();
		advisory_.setAdvisoryid(advisory.getAdvisoryid());
		System.out.println(advisory.getAdvisoryid());
		advisory_.setNews_Id(advisory.getSchoolNewsSubjectResult().getNews_Id());
		advisory_.setTitle(advisory.getTitle());
		advisory_.setUrlImg(advisory.getUrlImg());
		all.add(advisory_);
   }
   	*/
	results.setResults(all);
	results.setNumber(intpage);
	
	Gson gson =new Gson();
	String jsonObject= gson.toJson(results);
	HttpServletResponse response= ServletActionContext.getResponse();	
	response.setCharacterEncoding("UTF-8");
	response.setHeader("Content-type", "text/html;charset=UTF-8");
         PrintWriter out=response.getWriter();
    	 out.println(jsonObject);
    	// System.out.println(jsonObject);
    	 out.flush();
    	 out.close();
		return NONE;
	}
}
