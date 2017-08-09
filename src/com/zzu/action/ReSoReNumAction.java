package com.zzu.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Society;
import com.zzu.service.SocietyService;


@Controller(value="reSoReNumAction")
@Scope(value="prototype")
public class ReSoReNumAction extends ActionSupport{


	
	@Resource(name="societyServiceImpl")
	SocietyService societyService;
	@Resource(name="society")
	Society society;
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
	
		String id = request.getParameter("id");
		int readerNumber =Integer.parseInt(request.getParameter("readerNumber"));
		
		int i=Integer.parseInt(id);
		List all =(ArrayList)societyService.query(i);
		society =(Society)all.iterator().next();
		System.out.println(society.toString());
		System.out.println(society.getReaderNumber());
		readerNumber=readerNumber+Integer.parseInt(society.getReaderNumber());

	    society.setReaderNumber(String.valueOf(readerNumber));
	    societyService.update(society);
		return NONE;
	}

	
}
