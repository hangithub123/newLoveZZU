package life.topicCircle.action;

import java.io.PrintWriter;
import java.sql.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.topicCircle.entity.Topic;
import life.topicCircle.entity.TopicContent;
import life.topicCircle.service.TopicContentService;
import life.topicCircle.service.TopicService;


@Controller(value="addTopicContentAction")
@Scope(value="prototype")
public class AddTopicContentAction extends ActionSupport{

	@Resource(name="topicContent")
	private TopicContent topicContent;
	@Resource(name="topic")
	private Topic topic;
	
	@Resource(name="topicContentServiceImpl")
	private TopicContentService topicContentService;
	@Resource(name="topicServiceImpl")
	private TopicService topicService;
	
	private String phone;
	private String content;
	private Integer topicId;
	private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
			topic = topicService.get(Topic.class, topicId);
			int i = topic.getContentNumber()+1;
			topic.setContentNumber(i);
			
			topicContent.setContent(content);
			topicContent.setDate(new Date(new java.util.Date().getTime()));
			topicContent.setPhone(phone);
			topicContent.setPraiseNumber(0);
			topic.getTopicContent().add(topicContent);
			topicContentService.save(topicContent);
			topicService.update(topic);
			isSuccessful=true;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
}
