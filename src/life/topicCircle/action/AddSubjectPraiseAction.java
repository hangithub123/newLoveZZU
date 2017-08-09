package life.topicCircle.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.topicCircle.entity.Subject;
import life.topicCircle.entity.SubjectPraise;
import life.topicCircle.service.SubjectPraiseService;
import life.topicCircle.service.SubjectService;


@Controller(value="addSubjectPraiseAction")
@Scope(value="prototype")
public class AddSubjectPraiseAction extends ActionSupport{

	@Resource(name="subject")
	private Subject subject;
	@Resource(name="subjectPraise")
	private SubjectPraise subjectPraise;
	
	@Resource(name="subjectServiceImpl")
	private SubjectService subjectService;
	@Resource(name="subjectPraiseServiceImpl")
	private SubjectPraiseService subjectPraiseService;
	
	private Integer phone;
	private Integer subjectid;
	private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
		String sql="select t from SubjectPraise t where t.phone=? and t.subjectid=?";
		System.out.println("--------");
		List l=subjectPraiseService.query(sql,new Integer[]{phone,subjectid});
	  
		if(l.isEmpty()==true){
			subjectPraise.setPhone(phone);
			subjectPraise.setSubjectid(subjectid);
			subjectPraiseService.save(subjectPraise);
			Subject s = subjectService.get(Subject.class, subjectPraise.getSubjectid());
			
			int i =s.getPraiseNumber()+1;
			s.setPraiseNumber(i);
			subjectService.update(s);
		}
		isSuccessful = true ;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		HttpServletResponse response= ServletActionContext.getResponse();	
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	         PrintWriter out=response.getWriter();
	    	 out.println(isSuccessful);
	    	
	    	 out.flush();
	    	 out.close();
		}
		return NONE;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}
	
	
}
