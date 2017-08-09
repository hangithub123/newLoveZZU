package life.parTime.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.parTime.entity.PartTimeJob;
import life.parTime.service.PartTimeJobService;
@Controller(value="addPartTimeJobAction")
@Scope(value="prototype")
public class AddPartTimeJobAction extends ActionSupport{
	@Resource(name="partTimeJob")
	private PartTimeJob partTimeJob;
	@Resource(name="partTimeJobServiceImpl")
	private PartTimeJobService partTimeJobService;
	public String save() throws Exception {
		HttpServletRequest request =ServletActionContext.getRequest();
		
		partTimeJob.setTitle(request.getParameter("title"));
		partTimeJob.setContent(request.getParameter("content"));
		if(request.getParameter("indentifier").equals("0")){
			partTimeJob.setIdentifier((byte) 0);
		}else {
			partTimeJob.setIdentifier((byte) 1);
		}
		partTimeJob.setPhone(request.getParameter("phone"));
		Date date= new Date();
		partTimeJob.setPublish_date(date);
		partTimeJobService.save(partTimeJob);
		return SUCCESS;
	}
}
