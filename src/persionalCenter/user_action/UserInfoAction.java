package persionalCenter.user_action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import persionalCenter.entity.UserInfo;
import persionalCenter.service.UserService;
import zzu.util.Returndata;


@Transactional
@Controller(value="UserinfoAction")
@Component
@Scope(value="prototype")
public class UserInfoAction extends ActionSupport implements ModelDriven<UserInfo>{

	/**
	 * 修改和保存用户信息
	 */
	private static final long serialVersionUID = 1L;

	//注入service和实体类属性
		@Resource(name="User_Service")
		private UserService userService;
		
		private UserInfo userinfo=new UserInfo();
		
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userinfo;
	}
	@Override
	public String execute() throws Exception {
		boolean isSuccessful=false;
		System.out.println("模型驱动"+userinfo.toString());
		
		if(!userinfo.equals("") && !userinfo.getPhone().equals("")){
			
			isSuccessful=userService.updateUserInfo(userinfo);
		
		}else{System.out.println("客户端传来的userinfo数据为空");}
		userinfo=null;
		
			//返回数据
			Returndata.returnboolean(isSuccessful);

		return NONE;
	}

	
}
