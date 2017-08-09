package com.zzu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zzu.entity.SchoolNewsSubjectResult;
import com.zzu.service.SchoolNewsSubjectResultService;

@Controller(value="addNewsAction")
@Scope(value="prototype")
public class AddNewsAction extends ActionSupport implements ModelDriven<SchoolNewsSubjectResult>{

	
    @Resource(name="schoolNewsSubjectResultServiceImpl")
    private SchoolNewsSubjectResultService schoolNewsSubjectResultService;
    @Resource(name="schoolNewsSubjectResult")
	private SchoolNewsSubjectResult schoolNewsSubjectResult;
	@Override
	public SchoolNewsSubjectResult getModel() {
		// TODO Auto-generated method stub
		return schoolNewsSubjectResult;
	}
    public String upload() throws Exception{
    	schoolNewsSubjectResultService.save(schoolNewsSubjectResult);
    	return SUCCESS;
    }
}
