package com.zzu.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzu.entity.SocietyNews;
import com.zzu.service.SocietyNewsService;


@Controller(value="addSocietyNewsAction")
@Scope(value="prototype")
public class AddSocietyNewsAction extends ActionSupport implements ModelDriven<SocietyNews>{

	
	@Resource(name="societyNews")
	private SocietyNews societyNews;
	@Resource(name="societyNewsServiceImpl")
	private SocietyNewsService SocietyNewsService;
	
	@Override
	public SocietyNews getModel() {
		
		return societyNews;
	}

	public String save() throws Exception{
		SocietyNewsService.save(societyNews);
    	return SUCCESS;
    }
}
