package life.taoyu.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import life.taoyu.modeldriver.OrderAndItems;
import zzu.util.TestOO;
@Component(value = "TestAction")
@Scope(value = "prototype")
public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public String execute() throws Exception {
		
		return "sss"; 
	}
	public OrderAndItems getJson() throws IOException {
		OrderAndItems json=TestOO.GetJsonObject();
		HttpServletRequest r=ServletActionContext.getRequest();
		r.setAttribute("OAI", json);
		if(json !=null){}
		else{System.out.println("jsonÎª¿Õ");}
		return json;}
}
