package life.parTime.action;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;

import life.parTime.entity.PartTimeJob;
import life.parTime.service.PartTimeJobService;

@Component(value="findPartTimeJobAction")
@Scope(value="prototype")
public class findPartTimeJobAction extends ActionSupport{
	
	@Resource(name="partTimeJobServiceImpl")
	private PartTimeJobService partTimeJobService;
	
	private List<?> allJobs;
	private List<?> JobsByPhone;
	private List<?> JobsByIdentifier;
	private Object singleJob;

	
	
	public String  allJobs(){
		allJobs=partTimeJobService.findAll();
		
		return SUCCESS;
	}
	
	public String JobsByPhone(){
		HttpServletRequest request =ServletActionContext.getRequest();
		JobsByPhone=partTimeJobService.findPartTimeJobByPhone(request.getParameter("phone"));
		
		return SUCCESS;
	}
	
	public String JobsByIdentifier(){
		HttpServletRequest request =ServletActionContext.getRequest();
		String s=request.getParameter("identifier");
		Integer Identifier=new Integer(s);
		int identifier=Identifier;
		JobsByIdentifier=partTimeJobService.findPartTimeJobByIdentifier(identifier);
		
		return SUCCESS;
	}
	
	public String singleJob(){
		HttpServletRequest request =ServletActionContext.getRequest();
		Integer id=new Integer(request.getParameter("id"));
		singleJob=partTimeJobService.findPartTimeJobById(id);
		
		return SUCCESS;
	}

	public List<?> getAllJobs() {
		return allJobs;
	}

	public void setAllJobs(List<?> allJobs) {
		this.allJobs = allJobs;
	}

	public List<?> getJobsByPhone() {
		return JobsByPhone;
	}

	public void setJobsByPhone(List<?> jobsByPhone) {
		JobsByPhone = jobsByPhone;
	}

	public List<?> getJobsByIdentifier() {
		return JobsByIdentifier;
	}

	public void setJobsByIdentifier(List<?> jobsByIdentifier) {
		JobsByIdentifier = jobsByIdentifier;
	}

	public Object getSingleJob() {
		return singleJob;
	}

	public void setSingleJob(Object singleJob) {
		this.singleJob = singleJob;
	}
	
	
}
