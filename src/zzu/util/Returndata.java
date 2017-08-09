package zzu.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class Returndata {
	
public static void returndata(Object o) throws IOException{
	
	// 返回对象数据

	//如果中文返回出现？？字符，这表明没有加response.setCharacterEncoding("UTF-8");这句话。
  //如果返回的中文是“烇湫”这种乱码，说明浏览器的解析问题，应该检查下是否忘加response.setHeader("Content-type", "text/html;charset=UTF-8");这句话
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				
				PrintWriter out = response.getWriter();
				out.println(o);
				out.flush();
				out.close();
				System.out.println("返回app数据成功");
}
//返回布尔数据
public static void returnboolean(boolean isSuccessful) throws IOException{
	
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setHeader("Content-type", "text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
	JSONObject json = new JSONObject();
	json.put("isSuccessful", isSuccessful);
	
	PrintWriter out = response.getWriter();
	out.println(json);
	out.flush();
	out.close();
	System.out.println("返回app数据成功");
}
}
