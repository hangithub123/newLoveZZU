package life.topicCircle.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.topicCircle.entity.Topic;
import life.topicCircle.entity.TopicPraise;
import life.topicCircle.service.TopicPraiseService;
import life.topicCircle.service.TopicService;


@Controller(value="addTopicPraiseAction")
@Scope(value="prototype")
public class AddTopicPraiseAction extends ActionSupport{

	@Resource(name="topic")
	private Topic topic;
	@Resource(name="topicPraise")
	private TopicPraise topicPraise;
	
	@Resource(name="topicServiceImpl")
	private TopicService topicService;
	@Resource(name="topicPraiseServiceImpl")
	private TopicPraiseService topicPraiseService;
	
	private Integer phone;
	private Integer topicid;
	private boolean isSuccessful=false;
	
	@Override
	public String execute() throws Exception {
		try{
		String sql="select t from TopicPraise t where t.phone=? and t.topicid=?";
		System.out.println("--------");
		List l=topicPraiseService.query(sql,new Integer[]{phone,topicid});
	  
		if(l.isEmpty()==true){
			topicPraise.setPhone(phone);
			topicPraise.setTopicid(topicid);
			topicPraiseService.save(topicPraise);
			Topic t = topicService.get(Topic.class, topicPraise.getTopicid());
			
			int i =t.getPraiseNumber()+1;
			t.setPraiseNumber(i);
			topicService.update(t);
		}
		isSuccessful = true;
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
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	
}
