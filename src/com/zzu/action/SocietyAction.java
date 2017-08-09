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
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Society;
import com.zzu.entity.SocietyResults;
import com.zzu.service.SocietyService;

@Transactional
@Component(value="societyAction")
@Scope(value="prototype")
public class SocietyAction extends ActionSupport{

	//◊¢»Î Ù–‘
		@Resource(name="societyServiceImpl")
		private SocietyService societyService;
		@Resource(name="society")
		private Society society;
		@Resource(name="societyResults")
		private SocietyResults results;
		
		public String execute() throws Exception {
				
			HttpServletRequest request =ServletActionContext.getRequest();
			request.setCharacterEncoding("UTF-8");
			String page=request.getParameter("page");
			int intpage= Integer.parseInt(page);
			
			//List all=(ArrayList)advisoryService.findAll();
			List all =(ArrayList)societyService.findByPage( intpage, 2);
			
			results.setResult(all);
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
