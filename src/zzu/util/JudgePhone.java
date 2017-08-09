package zzu.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class JudgePhone {
	public static String judge(){
		String appOrweb=null;
	
	HttpServletRequest request=ServletActionContext.getRequest();
	String ua=request.getHeader("User-Agent");

	System.out.println("ua:"+ua);
	boolean Web=ua.contains("Windows");
	boolean Phone=ua.contains("okhttp");
	boolean PhoneWeb=ua.contains("Linux");
	
	if(Web == true || PhoneWeb == true){
		appOrweb="web";
	}
	else if(Phone == true){
		appOrweb="app";
	}
	else{System.out.println("请求来源app还是web判断这里出错");}
	return appOrweb;
	
	
	
	}

}
