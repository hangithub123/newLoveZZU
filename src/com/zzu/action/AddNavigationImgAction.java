package com.zzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Navigation;
import com.zzu.service.NavigationService;


@Controller(value="addNavigationImgAction")
@Scope(value="prototype")
public class AddNavigationImgAction extends ActionSupport{

	//注入属性
	@Resource(name="navigationServiceImpl")
	private NavigationService navigationService;
	@Resource(name="navigation")
	private Navigation navigation;
	
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	private boolean isSuccessful=false;
	public String upload() throws Exception{
		try{
		HttpServletRequest request= ServletActionContext.getRequest();
		String realPath = request.getRealPath("/").substring(0, request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		File file = new File(realPath+File.separator+"uploadNavigationFiles"+File.separator);
		//创建文件上传的位置
        if(!file.exists() ){
            file.mkdirs();   
            System.out.println("文件夹不存在已创建");
        }else{
            System.out.println("文件夹已经存在");
        }
		String strNewFileName = UUID.randomUUID().toString();
		String suffix=myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName +=suffix;
		System.out.println(strNewFileName);
		String fullPath=realPath+"uploadNavigationFiles"+File.separator+strNewFileName;
		System.out.println("上传路径："+fullPath);
		FileOutputStream fos=new FileOutputStream(fullPath);
		myUploadFileName=strNewFileName;
		FileInputStream fis=new FileInputStream(getMyUpload());
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		fos.close();
		fis.close();
		
		fullPath="http://localhost:8080/uploadNavigationFiles/"+strNewFileName;
		navigation.setImgUrl(fullPath);
		navigationService.save(navigation);
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
		return SUCCESS;	
	}
	public File getMyUpload() {
		return myUpload;
	}
	public void setMyUpload(File myUpload) {
		this.myUpload = myUpload;
	}
	public String getMyUploadFileName() {
		return myUploadFileName;
	}
	public void setMyUploadFileName(String myUploadFileName) {
		this.myUploadFileName = myUploadFileName;
	}
	public String getMyUploadContentType() {
		return myUploadContentType;
	}
	public void setMyUploadContentType(String myUploadContentType) {
		this.myUploadContentType = myUploadContentType;
	}
}
