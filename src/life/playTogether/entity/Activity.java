package life.playTogether.entity;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component(value="activity")
public class Activity {
	private int a_id;
	private String a_phone;
	private String a_userName;//�û���
	private String a_userImg;//�û�ͷ��URL��ַ
	private Date a_date;//������ʱ��
	private String a_title;//�����ı���
	private String a_img;//������ͼƬURL��ַ
	private String a_content;//����������
	private int a_praiseNumber;//������
	private int a_commentNumber;//������
	private String a_shareUrl;//����URL��ַ
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public String getA_userName() {
		return a_userName;
	}
	public void setA_userName(String a_userName) {
		this.a_userName = a_userName;
	}
	public String getA_userImg() {
		return a_userImg;
	}
	public void setA_userImg(String a_userImg) {
		this.a_userImg = a_userImg;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_img() {
		return a_img;
	}
	public void setA_img(String a_img) {
		this.a_img = a_img;
	}
	public String getA_content() {
		return a_content;
	}
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}
	public int getA_praiseNumber() {
		return a_praiseNumber;
	}
	public void setA_praiseNumber(int a_praiseNumber) {
		this.a_praiseNumber = a_praiseNumber;
	}
	public int getA_commentNumber() {
		return a_commentNumber;
	}
	public void setA_commentNumber(int a_commentNumber) {
		this.a_commentNumber = a_commentNumber;
	}
	public String getA_shareUrl() {
		return a_shareUrl;
	}
	public void setA_shareUrl(String a_shareUrl) {
		this.a_shareUrl = a_shareUrl;
	}
	
	
	
}
