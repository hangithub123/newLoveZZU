package persionalCenter.user_action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import net.sf.json.JSONObject;
import persionalCenter.entity.User;
import persionalCenter.service.UserService;
import zzu.util.JudgePhone;
import zzu.util.Judge_character;
import zzu.util.Returndata;


@Transactional
@Component(value="loginAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//注入属性
	@Resource(name="User_Service")
	private UserService userService;
	
	
	private User user=new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		
           
		Judge_character j=new Judge_character();
		String SessionID=null;
		String info=null;
		if( j.character(user.getPhone())){
		System.out.println("LoginAction层User首次登陆"+user.toString());
		SessionID=userService.query(user);
		}else {
			if(user.getSessionID() !=null && !user.getSessionID().isEmpty()){
				System.out.println("用户再次登陆操作,SessionID:"+user.getSessionID().toString());
				SessionID=userService.againquery(user);
				if(SessionID == null || SessionID.equals("")){
					info="登录失败，用户不存在";				
				}else{System.out.println("SeesionID登陆");info="SessionID登陆";}
				
			}else{
			info="客户端传来的手机号和SessionID数据都为空或不合法";
			System.out.println("客户端传来的手机号和SessionID数据都为空");}
			}
	
		
		
	

		//返回数据
		
		
		JSONObject json = new JSONObject();   
      	 json.put("SessionID", SessionID);    	
   	     json.put("info", info);    	
         System.out.println("LoginAction层json"+json);
		Returndata.returndata(json);

	
		
		return null;
	}
	
	
	 

 


}
