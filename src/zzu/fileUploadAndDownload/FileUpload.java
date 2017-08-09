package zzu.fileUploadAndDownload;

//上传多个文件
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

import life.taoyu.entity.Goods;
import life.taoyu.service.TaoyuService;
import net.sf.json.JSONObject;
import zzu.util.GetDate;
import zzu.util.Panduanstr;
import zzu.util.Returndata;

@Component(value = "imagesupload")
@Scope(value = "prototype")
public class FileUpload extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 上传文件域

	//private File[] images = new File[10];
	 ArrayList<File> images=new ArrayList<File>();
	public ArrayList<File> getImages() {
		return images;
	}
	public void setImages(ArrayList<File> images) {
		this.images = images;
	}

	// 上传文件类型
	private String[] imagesContentType = new String[10];
	// 封装上传文件名
	private String[] imagesFileName = new String[10];

	private String goods_id;
	private String SessionID;
	private String action = null;

	private String[] DNames = null;// 指定要删除的图片数组

	@Resource(name = "getdata")
	private GetDate data;
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;

	HttpServletRequest request = ServletActionContext.getRequest();
	boolean isSuccessful = false;
	String[] str = null;// str[0] 是放Account，str[1]是放获取数据库中的旧的图片名
	String[] imagenames = null;// 存放获取的旧的图片名
	Panduanstr p = new Panduanstr();
	Goods goods = new Goods();

	

	@Override
	public String execute() throws FileNotFoundException, IOException {
		Upload u=new Upload();
		if (action != null) {
		switch (action) {
			case "上传商品图片": boolean b=getDBinfo();
			if(b){ isSuccessful=u.run();}
				break;
				
			case "上传话题圈图片":
				break;
				
			default:
				break;
			}
		}
			
			

			// 返回数据
				
			Returndata.returnboolean(isSuccessful);
					

		return null;
	}
public boolean getDBinfo(){
	// 获取数据库中记录信息
	boolean b=false;
	if(images==null){System.out.println("图片文件为空");return b;}
				if (goods_id != null && !goods_id.equals("") && SessionID != null && !SessionID.equals("")) {
					str = taoyuService.getImageName(SessionID, goods_id);
					if (str == null) {
						System.err.println("未检索到数据库中商品信息");
						return b;
					}
					goods.setGoods_id(Integer.parseInt(goods_id));
					if (str[1] != null)
						imagenames = p.fenli(str[1]);
                  b=true;
				} else {
					System.err.println("上传商品图片时SessionID或商品id为空");
					}	
				return b;
   }
	class Upload  {

		
		public boolean run() {isSuccessful=false;
			List<String> l = new ArrayList<>();// 建保存新图片名的集合，用于后面拼接成字符串更新到数据库
			// 图片存放路径
			String realPath = request.getRealPath("/").substring(0,
					request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")))
					+ "goodsuploadImage" + File.separator;
			System.out.println("文件存放目录: " + realPath);
			FileOutputStream fos = null;
			FileInputStream fis = null;
			System.out.println("action:" + action);
			try {

				File file = new File(realPath);

				// 创建文件上传的位置
				if (!file.exists()) {
					file.mkdirs();
					System.out.println("文件夹不存在已创建");
				} else {
					System.out.println("文件夹已经存在");
				}

				// 上传文件

				for (int i = 0; i < images.size(); i++) {
					String sss = getImagesContentType()[i];
					System.out.println("类型:" + sss);
					String suffix = getImagesFileName()[i].substring(getImagesFileName()[i].lastIndexOf("."));
					String name = str[0] + data.GetNowDate2() + UUID.randomUUID().toString() + suffix; // 设置图片名=用户账户+目前时间+UUID
					l.add(name);
System.out.println("存储路径:"+realPath+name);
					fos = new FileOutputStream(realPath + name);
					//fis = new FileInputStream(images[i]);
					 fis=new FileInputStream(images.get(i));
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) != -1) {
						fos.write(buffer, 0, len);
					}
				}
				isSuccessful=true;
			} catch (FileNotFoundException e) {
				System.err.println("文件不存在" + e.getMessage());
			} catch (Exception e) {
				System.err.println("文件上传失败");
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			System.out.println("多文件上传操作成功");
			updategoods(l);//更新商品图片信息
			return isSuccessful;
			
		}
			
	}

	public void updategoods(List<String> l) {
		String imageurl = p.pinjie(l);// 拼接成字符串
		if(str[1]!=null)
		imageurl += str[1];// 数据库中和新生成的图片名拼接

		if (imageurl != null && !imageurl.equals("")) {
			goods.setGimage(imageurl);
			taoyuService.updateGoods(goods);
			
			isSuccessful = true;
		}
	}

	// 删除图片方法
	public void deletePicture() throws Exception {
		String realPath = request.getRealPath("/").substring(0,
				request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", ""))) + "goodsuploadImage"
				+ File.separator;

		if (action.equals("删除图片") && imagenames != null) {
			FileDelete d = new FileDelete();
			String newImgnames = d.delete(realPath, str[1], DNames);// 返回新的imageurl
			if (newImgnames != null) {
				goods.setGimage(newImgnames);
				taoyuService.updateGoods(goods);
				
			}
			isSuccessful = true;

		}
	}

	/**
	 * 属性注入
	 * 
	 * @return
	 */
	public String[] getDNames() {// 发来的要删除的图片名
		return DNames;
	}

	public void setDNames(String[] dNames) {
		DNames = dNames;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

//	public File[] getImages() {
//		return images;
//	}
//
//	public void setImages(File[] images) {
//		this.images = images;
//	}

	public String[] getImagesContentType() {
		return imagesContentType;
	}

	public void setImagesContentType(String[] imagesContentType) {
		this.imagesContentType = imagesContentType;
	}

	public String[] getImagesFileName() {
		return imagesFileName;
	}

	public void setImagesFileName(String[] imagesFileName) {
		this.imagesFileName = imagesFileName;
	}

}

