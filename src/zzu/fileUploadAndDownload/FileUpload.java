package zzu.fileUploadAndDownload;

//�ϴ�����ļ�
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
	// �ϴ��ļ���

	//private File[] images = new File[10];
	 ArrayList<File> images=new ArrayList<File>();
	public ArrayList<File> getImages() {
		return images;
	}
	public void setImages(ArrayList<File> images) {
		this.images = images;
	}

	// �ϴ��ļ�����
	private String[] imagesContentType = new String[10];
	// ��װ�ϴ��ļ���
	private String[] imagesFileName = new String[10];

	private String goods_id;
	private String SessionID;
	private String action = null;

	private String[] DNames = null;// ָ��Ҫɾ����ͼƬ����

	@Resource(name = "getdata")
	private GetDate data;
	@Resource(name = "taoyuService")
	private TaoyuService taoyuService;

	HttpServletRequest request = ServletActionContext.getRequest();
	boolean isSuccessful = false;
	String[] str = null;// str[0] �Ƿ�Account��str[1]�ǷŻ�ȡ���ݿ��еľɵ�ͼƬ��
	String[] imagenames = null;// ��Ż�ȡ�ľɵ�ͼƬ��
	Panduanstr p = new Panduanstr();
	Goods goods = new Goods();

	

	@Override
	public String execute() throws FileNotFoundException, IOException {
		Upload u=new Upload();
		if (action != null) {
		switch (action) {
			case "�ϴ���ƷͼƬ": boolean b=getDBinfo();
			if(b){ isSuccessful=u.run();}
				break;
				
			case "�ϴ�����ȦͼƬ":
				break;
				
			default:
				break;
			}
		}
			
			

			// ��������
				
			Returndata.returnboolean(isSuccessful);
					

		return null;
	}
public boolean getDBinfo(){
	// ��ȡ���ݿ��м�¼��Ϣ
	boolean b=false;
	if(images==null){System.out.println("ͼƬ�ļ�Ϊ��");return b;}
				if (goods_id != null && !goods_id.equals("") && SessionID != null && !SessionID.equals("")) {
					str = taoyuService.getImageName(SessionID, goods_id);
					if (str == null) {
						System.err.println("δ���������ݿ�����Ʒ��Ϣ");
						return b;
					}
					goods.setGoods_id(Integer.parseInt(goods_id));
					if (str[1] != null)
						imagenames = p.fenli(str[1]);
                  b=true;
				} else {
					System.err.println("�ϴ���ƷͼƬʱSessionID����ƷidΪ��");
					}	
				return b;
   }
	class Upload  {

		
		public boolean run() {isSuccessful=false;
			List<String> l = new ArrayList<>();// ��������ͼƬ���ļ��ϣ����ں���ƴ�ӳ��ַ������µ����ݿ�
			// ͼƬ���·��
			String realPath = request.getRealPath("/").substring(0,
					request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", "")))
					+ "goodsuploadImage" + File.separator;
			System.out.println("�ļ����Ŀ¼: " + realPath);
			FileOutputStream fos = null;
			FileInputStream fis = null;
			System.out.println("action:" + action);
			try {

				File file = new File(realPath);

				// �����ļ��ϴ���λ��
				if (!file.exists()) {
					file.mkdirs();
					System.out.println("�ļ��в������Ѵ���");
				} else {
					System.out.println("�ļ����Ѿ�����");
				}

				// �ϴ��ļ�

				for (int i = 0; i < images.size(); i++) {
					String sss = getImagesContentType()[i];
					System.out.println("����:" + sss);
					String suffix = getImagesFileName()[i].substring(getImagesFileName()[i].lastIndexOf("."));
					String name = str[0] + data.GetNowDate2() + UUID.randomUUID().toString() + suffix; // ����ͼƬ��=�û��˻�+Ŀǰʱ��+UUID
					l.add(name);
System.out.println("�洢·��:"+realPath+name);
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
				System.err.println("�ļ�������" + e.getMessage());
			} catch (Exception e) {
				System.err.println("�ļ��ϴ�ʧ��");
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

			System.out.println("���ļ��ϴ������ɹ�");
			updategoods(l);//������ƷͼƬ��Ϣ
			return isSuccessful;
			
		}
			
	}

	public void updategoods(List<String> l) {
		String imageurl = p.pinjie(l);// ƴ�ӳ��ַ���
		if(str[1]!=null)
		imageurl += str[1];// ���ݿ��к������ɵ�ͼƬ��ƴ��

		if (imageurl != null && !imageurl.equals("")) {
			goods.setGimage(imageurl);
			taoyuService.updateGoods(goods);
			
			isSuccessful = true;
		}
	}

	// ɾ��ͼƬ����
	public void deletePicture() throws Exception {
		String realPath = request.getRealPath("/").substring(0,
				request.getRealPath("/").lastIndexOf(request.getContextPath().replace("/", ""))) + "goodsuploadImage"
				+ File.separator;

		if (action.equals("ɾ��ͼƬ") && imagenames != null) {
			FileDelete d = new FileDelete();
			String newImgnames = d.delete(realPath, str[1], DNames);// �����µ�imageurl
			if (newImgnames != null) {
				goods.setGimage(newImgnames);
				taoyuService.updateGoods(goods);
				
			}
			isSuccessful = true;

		}
	}

	/**
	 * ����ע��
	 * 
	 * @return
	 */
	public String[] getDNames() {// ������Ҫɾ����ͼƬ��
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

