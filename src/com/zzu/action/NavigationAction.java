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
import com.zzu.entity.Navigation;
import com.zzu.entity.NavigationResults;
import com.zzu.service.NavigationService;


@Transactional
@Component(value="navigationAction")
@Scope(value="prototype")
public class NavigationAction extends ActionSupport{

	//◊¢»Î Ù–‘
		@Resource(name="navigationServiceImpl")
		private NavigationService navigationService;
		@Resource(name="navigation")
		private Navigation navigation;
		@Resource(name="navigationResults")
		private NavigationResults results;
		public String execute() throws Exception {
				
			List all =(ArrayList)navigationService.findAll();
			results.setResult(all);
			Gson gson =new Gson();
			String jsonObject= gson.toJson(results);
			HttpServletResponse response= ServletActionContext.getResponse();	
			
		         PrintWriter out=response.getWriter();
		    	 out.println(jsonObject);
		    	
		    	 out.flush();
		    	 out.close();
				return NONE;
			}
}
