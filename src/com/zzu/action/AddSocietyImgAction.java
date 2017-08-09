package com.zzu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Society;
import com.zzu.service.SocietyService;


@Controller(value="addSocietyImgAction")
@Scope(value="prototype")
public class AddSocietyImgAction extends ActionSupport{

	//注入属性
	@Resource(name="societyServiceImpl")
	private SocietyService societyService;
	@Resource(name="society")
	private Society society;
	
	private String title;
	private String time;
	private String readerNumber;
	private Integer News_Id;
	
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	public String upload() throws Exception{
		System.out.println("");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		String realPath = request.getRealPath("/").substring(0, request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		System.out.println(realPath);
		File file = new File(realPath+File.separator+"uploadSocietyFiles"+File.separator);
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
		String fullPath=realPath+"uploadSocietyFiles"+File.separator+strNewFileName;
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
		
		fullPath="http://localhost:8080/uploadSocietyFiles/"+strNewFileName;
		society.setImgUrl(fullPath);
		society.setTitle(title);
		society.setTime(time);
		society.setReaderNumber(readerNumber);
		society.setNews_Id(News_Id);
		societyService.save(society);
		return SUCCESS;	
	}
	public Integer getNews_Id() {
		return News_Id;
	}
	public void setNews_Id(Integer news_Id) {
		News_Id = news_Id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReaderNumber() {
		return readerNumber;
	}
	public void setReaderNumber(String readerNumber) {
		this.readerNumber = readerNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
