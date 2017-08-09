package persionalCenter.confessionWall.action;

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

import persionalCenter.confessionWall.entity.BareHeart;
import persionalCenter.confessionWall.service.BareHeartService;

@Controller(value="addBareHeartAction")
@Scope(value="prototype")
public class AddBareHeartAction extends ActionSupport{

	//注入属性
		@Resource(name="bareHeartServiceImpl")
		private BareHeartService bareHeartService;
		@Resource(name="bareHeart")
		private BareHeart bareHeart;
		
		
		private String title;
		private String phone;

		private File myUpload;
		private String myUploadFileName;
		private String myUploadContentType;
		private boolean isSuccessful=false;
		public String upload() throws Exception{
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
			bareHeart.setUrlImg(fullPath);
			bareHeart.setTitle(title);
			bareHeart.setCommentNumber(0);
			bareHeart.setPraise(0);
			bareHeart.setUrlImg(fullPath);
			bareHeart.setPhone(phone);
			bareHeartService.save(bareHeart);
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
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
