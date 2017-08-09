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
import com.zzu.entity.Carousel;
import com.zzu.entity.CarouselResults;
import com.zzu.service.CarouselService;

@Transactional
@Component(value="carouselAction")
@Scope(value="prototype")
public class CarouselAction extends ActionSupport{

	//◊¢»Î Ù–‘
		@Resource(name="carouselServiceImpl")
		private CarouselService carouselService;
		@Resource(name="carousel")
		private Carousel carousel;
		@Resource(name="carouselResults")
		private CarouselResults results;
		String jsonObject=null;
		public String execute() throws Exception {
			try{	
			List all =(ArrayList)carouselService.findAll();
			results.setResult(all);
			Gson gson =new Gson();
		    jsonObject= gson.toJson(results);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				HttpServletResponse response= ServletActionContext.getResponse();	
		         PrintWriter out=response.getWriter();
		    	 out.println(jsonObject);
		    	 out.flush();
		    	 out.close();
			}
				return NONE;
			}
}
