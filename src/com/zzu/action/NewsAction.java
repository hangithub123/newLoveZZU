package com.zzu.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Results;
import com.zzu.entity.SchoolNewsSubjectResult;
import com.zzu.service.SchoolNewsSubjectResultService;
@Component(value="newsAction")
@Scope(value="prototype")
public class NewsAction extends ActionSupport{

	@Resource(name="schoolNewsSubjectResultServiceImpl")
	private SchoolNewsSubjectResultService schoolNewsSubjectResultService;
	@Resource(name="schoolNewsSubjectResult")
	private SchoolNewsSubjectResult schoolNewsSubjectResult;
	@Resource(name="results")
	private Results results;
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String News_Id=request.getParameter("News_Id");
		List all =(ArrayList)schoolNewsSubjectResultService.query("from SchoolNewsSubjectResult  where News_Id = "+News_Id);
		results.setNumber(1);
		results.setResults(all);
		Gson gson =new Gson();
		String jsonObject= gson.toJson(results);
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
