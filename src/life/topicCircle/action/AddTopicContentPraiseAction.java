package life.topicCircle.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.topicCircle.entity.TopicContent;
import life.topicCircle.entity.TopicContentPraise;
import life.topicCircle.service.TopicContentPraiseService;
import life.topicCircle.service.TopicContentService;

@Controller(value="addTopicContentPraiseAction")
@Scope(value="prototype")
public class AddTopicContentPraiseAction extends ActionSupport{

	@Resource(name="topicContent")
	private TopicContent topicContent;
	@Resource(name="topicContentPraise")
	private TopicContentPraise topicContentPraise;
	
	@Resource(name="topicContentServiceImpl")
	private TopicContentService topicContentService;
	@Resource(name="topicContentPraiseServiceImpl")
	private TopicContentPraiseService topicContentPraiseService;
	
	private Integer phone;
	private Integer topicContentid;
	private boolean isSuccessful=false;
	@Override
	public String execute() throws Exception {
		try{
		String sql="select t from TopicPraise t where t.phone=? and t.topicid=?";
		List l=topicContentPraiseService.query(sql,new Integer[]{phone,topicContentid});
	  
		if(l.isEmpty()==true){
			topicContentPraise.setPhone(phone);
			topicContentPraise.setTopicContentid(topicContentid);
			topicContentPraiseService.save(topicContentPraise);
			TopicContent t = topicContentService.get(TopicContent.class, topicContentPraise.getTopicContentid());
			
			int i =t.getPraiseNumber()+1;
			t.setPraiseNumber(i);
			topicContentService.update(t);
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
	public Integer getTopicContentid() {
		return topicContentid;
	}
	public void setTopicContentid(Integer topicContentid) {
		this.topicContentid = topicContentid;
	}
	
	
}
