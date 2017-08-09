package zzu.fileUploadAndDownload;

import java.io.DataOutputStream;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import persionalCenter.entity.UserInfo;
import persionalCenter.service.UserService;
import zzu.util.Returndata;

@Component(value = "imageupload")
@Scope(value = "prototype")
public class FileAction extends ActionSupport {

	/**
	 * 
	 */
	@Resource(name = "User_Service")
	private UserService userService;

	private static final long serialVersionUID = 1L;
	private String SessionID;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
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

	
	public String upload() throws FileNotFoundException, IOException {
		String[] str = new String[10];// str[0]
										// 是放最新生成的图片名，str[1]是放获取数据库中的用户手机号，str[2]是放获取数据库中的旧的图片名
		boolean isSuccessful = false;
		String imageurl = null;
		System.out.println("客户端上传单个图片，发来的SessionID:" + SessionID);
		HttpServletRequest request = ServletActionContext.getRequest();
		//判断上传文件是否存在
        if(myUpload ==null || !myUpload.exists()){
        	System.err.println("上传文件不存在");
        	return null;}
		UserInfo userinfo = new UserInfo();
		if (SessionID != null) {
			str = userService.getImageName(SessionID);
			userinfo.setPhone(str[1]);
		} else {
			System.err.println("上传图片时SessionID为空");
			return null;
		}

		String strNewFileName = str[0];// 获得图片名
	
		@SuppressWarnings("deprecation")
		String realPath = request.getRealPath("/").substring(0,
				request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")));
		File file = new File(realPath + File.separator + "uploadFiles" + File.separator);

		// 创建文件上传的位置
		if (!file.exists()) {
			file.mkdirs();

			System.out.println("文件夹不存在已创建");
		} else {
			System.out.println("文件夹已经存在");
		}
		System.out.println("文件名:" + myUpload.getName());

		String suffix = myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName += suffix;
		FileOutputStream fos = new FileOutputStream(
				realPath + File.separator + "uploadFiles" + File.separator + strNewFileName);
		myUploadFileName = strNewFileName;

		// 图片名保存到数据库
		userinfo.setImageUrl(myUploadFileName);
		
		// 读取和保存图片文件
		FileInputStream fis = new FileInputStream(getMyUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {

			fos.write(buffer, 0, len);

		}
		System.out.println("成功保存到上传的图片");
		fos.close();
		fis.close();
		String filepath = realPath + "uploadFiles" + File.separator + myUploadFileName;
		System.out.println("文件上传路径:" + filepath);
		// 删除图片
		
		if ( SessionID != null && str[2] !=null && !str[2].equals("")) {
			File f = new File(realPath + "uploadFiles" + File.separator + str[2]);

			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

			if (f.exists()) {
				System.out.println("查到已有图片开始删除操作：" + f.getAbsoluteFile());
				dos.close();

				if (!f.delete()) {
					System.out.println("请关闭使用该文件的所有进程或者流！！");
				} else {
					System.out.println(f.getName() + " 成功被删除！");
				}
			} else {
				System.out.println("没查到已有图片");
			}
			
		}
		boolean b = userService.updateUserInfo(userinfo);
		System.out.println("是否图片名保存数据库操作:" + b);

		isSuccessful = b;
		imageurl = myUploadFileName;

		// 返回数据
		JSONObject json = new JSONObject();

		json.put("isSuccessful", isSuccessful);
		json.put("imageurl", imageurl);
		Returndata.returndata(json);

		return SUCCESS;

	}

}
