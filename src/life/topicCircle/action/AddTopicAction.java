package life.topicCircle.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import life.topicCircle.entity.Subject;
import life.topicCircle.entity.Topic;
import life.topicCircle.service.SubjectService;
import life.topicCircle.service.TopicService;
@Controller(value="addTopicAction")
@Scope(value="prototype")
public class AddTopicAction extends ActionSupport{

	@Resource(name="topic")
	private Topic topic;
	@Resource(name="subject")
	private Subject subject;
	
	@Resource(name="topicServiceImpl")
	private TopicService topicService;
	@Resource(name="subjectServiceImpl")
	private SubjectService subjectService;

	private String phone;
	private String content;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	private boolean isSuccessful=false;
	private Integer subjectId;
	@Override
	public String execute() throws Exception {

		try{
	    	
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
			
			subject = subjectService.get(Subject.class, subjectId);
			int i = subject.getContentNumber()+1;
			subject.setContentNumber(i);
			
			topic.setPhone(phone);
			topic.setContent(content);
			topic.setDate(new Date(new java.util.Date().getTime()));
			topic.setUrlImg(fullPath);
			topic.setContentNumber(0);
			topic.setPraiseNumber(0);
			
			subject.getTopic().add(topic);
			topicService.save(topic);
			subjectService.update(subject);
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
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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
