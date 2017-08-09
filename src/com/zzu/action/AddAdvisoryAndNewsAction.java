package com.zzu.action;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.zzu.entity.Advisory;
import com.zzu.entity.SchoolNewsSubjectResult;
import com.zzu.service.AdvisoryService;
import com.zzu.service.SchoolNewsSubjectResultService;


@Component(value="addAdvisoryAndNewsAction")
@Scope(value="prototype")
public class AddAdvisoryAndNewsAction extends ActionSupport{

	    //注入属性
		@Resource(name="advisoryServiceImpl")
		private AdvisoryService advisoryService;
		@Resource(name="advisory")
		private Advisory advisory;
		
		@Resource(name="schoolNewsSubjectResultServiceImpl")
		private SchoolNewsSubjectResultService schoolNewsSubjectResultService;
	    @Resource(name="schoolNewsSubjectResult")
	    private SchoolNewsSubjectResult schoolNewsSubjectResult;
	    
	    private String news_Title;
	    private String author;
	    private String subject;
	    private String time;
	    private String readNumber;
		private String likesNumber;
	    private String commentNumber;
	   
		private String title;
		private File myUpload;
		private String myUploadFileName;
		private String myUploadContentType;
		public String upload() throws Exception{
			System.out.println("");
			HttpServletRequest request= ServletActionContext.getRequest();
			String realPath = request.getRealPath("/").substring(0, request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
			System.out.println(realPath);
			File file = new File(realPath+File.separator+"uploadFiles"+File.separator);
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
			String fullPath=realPath+"uploadFiles"+File.separator+strNewFileName;
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
			
			fullPath="http://192.168.1.100:8080/uploadFiles/"+strNewFileName;
			
			schoolNewsSubjectResult.setAuthor(author);
			schoolNewsSubjectResult.setCommentNumber(commentNumber);
			schoolNewsSubjectResult.setLikesNumber(likesNumber);
			schoolNewsSubjectResult.setNews_Title(news_Title);
			schoolNewsSubjectResult.setReadNumber(readNumber);
			schoolNewsSubjectResult.setSubject(subject);
			schoolNewsSubjectResult.setTime(time);
			
			advisory.setUrlImg(fullPath);
			advisory.setTitle(title);
		
			
			schoolNewsSubjectResultService.save(schoolNewsSubjectResult);
			
			advisoryService.save(advisory);
			
			return SUCCESS;	
		}
		
		
		public String getNews_Title() {
			return news_Title;
		}


		public void setNews_Title(String news_Title) {
			this.news_Title = news_Title;
		}


		public String getAuthor() {
			return author;
		}


		public void setAuthor(String author) {
			this.author = author;
		}


		public String getSubject() {
			return subject;
		}


		public void setSubject(String subject) {
			this.subject = subject;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public String getReadNumber() {
			return readNumber;
		}


		public void setReadNumber(String readNumber) {
			this.readNumber = readNumber;
		}


		public String getLikesNumber() {
			return likesNumber;
		}


		public void setLikesNumber(String likesNumber) {
			this.likesNumber = likesNumber;
		}


		public String getCommentNumber() {
			return commentNumber;
		}


		public void setCommentNumber(String commentNumber) {
			this.commentNumber = commentNumber;
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
