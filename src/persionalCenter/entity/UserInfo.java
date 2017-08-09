package persionalCenter.entity;

import org.springframework.stereotype.Component;

@Component(value="UserInfo")
public class UserInfo {

	private Integer info_id;

	private String imageUrl;//头像地址
	private String nickname;//昵称
	private String phone;//手机号
	private String Qr_codeUrl; //二维码地址
	private String gender;//性别
	private String hometown ;//家乡
	private String academy;//院校
	private String departments ;//院系
	private String professional ;//专业
	private User user;
	public Integer getInfo_id() {
		return info_id;
	}
	public void setInfo_id(Integer info_id) {
		this.info_id = info_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQr_codeUrl() {
		return Qr_codeUrl;
	}
	public void setQr_codeUrl(String qr_codeUrl) {
		Qr_codeUrl = qr_codeUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getDepartments() {
		return departments;
	}
	public void setDepartments(String departments) {
		this.departments = departments;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}

	@Override
	public String toString() {
		return "UserInfo [imageUrl=" + imageUrl + ", nickname=" + nickname + ", phone=" + phone + ", gender=" + gender
				+ ", hometown=" + hometown + ", academy=" + academy + ", departments=" + departments + ", professional="
				+ professional + "]";
	}
	
}
