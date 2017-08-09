package persionalCenter.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import persionalCenter.dao.Dao;
import persionalCenter.dao.Userdao;
import persionalCenter.entity.User;
import persionalCenter.entity.UserInfo;
import zzu.util.GetDate;
@Transactional
@Component(value="User_Service")
public class UserService {

	@Resource(name="user_Dao")
	private Dao dao;
	
	private GetDate data=new GetDate();
	
	

//�����û�����
	public boolean save(User user){
		  
		int account = 0;
		boolean	isSuccessful=false;
		Serializable	id=null;//��ʼ��id
		String	sql="from User where phone=?";
		String values=user.getPhone();
		List<User> list=dao.query(sql, values);
		if(list.isEmpty()){
			UserInfo userinfo=new UserInfo();
         userinfo.setPhone(user.getPhone());
         userinfo.setNickname("zzu"+user.getPhone());
         int j=1;
         for(int i=0;i<j;i++){
        	 j++;
        account=  (int)((Math.random()*9+1)*100000000);
         sql="from User where account=?";
 		values=account+"";
 		List<User> list2=dao.query(sql, values);
 		if(list2.isEmpty()){ j=0;}
         }
 		user.setAccount(account+"");
          userinfo.setUser(user);
			id=this.dao.save(user);
			this.dao.save(userinfo);
 		
		}else{System.out.println("�û�:"+user.getPhone()+"�Ѵ���");
		isSuccessful=false;}
			if(id !=null){
				isSuccessful=true;
				System.out.println("���û��ѱ��浽���ݿ�!");
			}
		
		return isSuccessful;
		 }
	

//�û��״ε�½��ѯ�û�����
	public String  query(User user) {
		
		String sessionid=null;
		String sql="from User where phone=? and password=?";
		String values1=user.getPhone();
		String values2=user.getPassword();
		List<User> list=this.dao.query(sql, values1,values2);
		if(!list.isEmpty()){
			boolean isSuccessful=true;
			System.out.println("�û�:"+user.getPhone()+"����");
			String phone=user.getPhone();
			String password=user.getPassword();
			String v_code=user.getVerification_code();
			 sessionid=UUID.randomUUID().toString();
			String sessionidata=data.GetNowDate();
			for (User user2 : list) {
				if(phone !=null && !phone.equals("")){user2.setPhone(phone);}
				if(password !=null && !password.equals("")){user2.setPassword(password);}
				if(v_code !=null && !v_code.equals("")){user2.setVerification_code(v_code);}
				if(sessionid !=null && !sessionid.equals("")){user2.setSessionID(sessionid);}
				if(sessionidata !=null && !sessionidata.equals("")){user2.setSessionIDDate(sessionidata);}
			    
				this.dao.update(user2);
			
			}
			
			
		}else{System.out.println("�û�:"+user.getPhone()+"������");
		}
		 
		return sessionid;
	}
		 
	
	//�û������״ε�½
	public String  againquery(User user) throws ParseException {
		 
		String sessionid=null;
		String sql="from User where SessionID=?";
		String values=user.getSessionID();
		List<User> list=this.dao.query(sql, values);
		if(!list.isEmpty()){
			for (User user2 : list) {
				String lastdate=user2.getSessionIDDate();
				String nowdate=data.GetNowDate();
				int day=data.getDataNum(lastdate, nowdate);
				if(day>-30 && day<30){
					String phone=user.getPhone();
					String password=user.getPassword();
					String v_code=user.getVerification_code();
					 sessionid=UUID.randomUUID().toString();
					String sessionidata=data.GetNowDate();
					if(phone !=null && !phone.equals("")){user2.setPhone(phone);}
					if(password !=null && !password.equals("")){user2.setPassword(password);}
					if(v_code !=null && !v_code.equals("")){user2.setVerification_code(v_code);}
					if(sessionid !=null && !sessionid.equals("")){user2.setSessionID(sessionid);}
					if(sessionidata !=null && !sessionidata.equals("")){user2.setSessionIDDate(sessionidata);}
				    
					this.dao.update(user2);
				}else{sessionid=null;System.out.println("�û����ϴε�½����30��");}
			}
		}
		 
		return sessionid;
		 }
	
	
//������޸��û���Ϣ
	public boolean updateUserInfo(UserInfo userinfo) {
		 
	boolean	isSuccessful=false;
	Serializable	id = null;//��ʼ��id
			//�õ�User����
		String sql="from User where phone=?";
		String values=userinfo.getPhone();
		List<User> list=this.dao.query(sql, values);
			
			for (User user : list) {
				//�õ�User�����id
			//����id��ѯ������userinfo������Ϊul_id=id�Ķ����Ƿ����
				sql="from UserInfo where ul_id=?";
				values=user.getUid().toString();
				System.out.println("Uid:"+values+sql+","+values);
				List<UserInfo> infolist=dao.query(sql, values);
				
				if(infolist.size() ==1){
				  
				if(userinfo.getAcademy() !=null && !userinfo.getAcademy().equals("")){	infolist.get(0).setAcademy(userinfo.getAcademy());}
			    if( userinfo.getDepartments() !=null && !userinfo.getDepartments().equals("")){infolist.get(0).setDepartments(userinfo.getDepartments());}
				if( userinfo.getGender() !=null && !userinfo.getGender().equals("")){	infolist.get(0).setGender(userinfo.getGender());}
				if( userinfo.getHometown() !=null && !userinfo.getHometown().equals("")){	infolist.get(0).setHometown(userinfo.getHometown());}
				if( userinfo.getImageUrl() !=null && !userinfo.getImageUrl().equals("")){	infolist.get(0).setImageUrl(userinfo.getImageUrl());}
				if( userinfo.getNickname() !=null && !userinfo.getNickname().equals("")){	infolist.get(0).setNickname(userinfo.getNickname());}
				if( userinfo.getPhone() !=null && !userinfo.getPhone().equals("")){	infolist.get(0).setPhone(userinfo.getPhone());}
				if( userinfo.getProfessional() !=null && !userinfo.getProfessional().equals("")){ infolist.get(0).setProfessional(userinfo.getProfessional());}
				if( userinfo.getQr_codeUrl() !=null && !userinfo.getQr_codeUrl().equals("")){ infolist.get(0).setQr_codeUrl(userinfo.getQr_codeUrl());}
				    
				
						this.dao.update(infolist.get(0));
					    System.out.println("�û���Ϣ�޸Ĳ���");
						id=1;
						
						isSuccessful=true;
				}	
				
			}

			if(id !=null){
			
				System.out.println("������Ϣ�ѱ��浽���ݿ�!");
			}else{
			System.out.println("Service�㣬UserInfo����Ϊ��!!!");
			}
			userinfo=null;
			id=null;
		return isSuccessful;
		 }
		
	
//��ѯ�������û���Ϣ
		public UserInfo query(UserInfo userinfo) {
			  
			
			Integer Uid=null;
			//����phone��ѯUser����
		String	sql="from User where phone=?";
		String	values=userinfo.getPhone();
			List<User> list=this.dao.query(sql, values);
			
			for (User user : list) {
				Uid=user.getUid();
			}
			if(Uid ==null){System.out.println("��ѯ�û���Ϣδ�������û�");return null;}
				//����User��id��ѯ������userinfo������Ϊul_id=id�Ķ����Ƿ����
				sql="from UserInfo where ul_id=?";
				values=Uid.toString();
				System.out.println("Uid:"+values+sql+","+values);
				List<UserInfo> list2=dao.query(sql, values);
	
			return list2.get(0);
			 }
			
		
//��ȡaccount������ͼƬ��
		public String[] getImageName(String SessionID){
			 
			String[] str =new String[10];
			String phone=null;
			String newimageurl=null;
			String oldimageurl=null;
		String	sql="from User where SessionID=?";
		String	values=SessionID;
			List<User> list2=dao.query(sql, values);
			
			if(!list2.isEmpty()){
			for (User user : list2) {
				newimageurl=user.getAccount();
			    phone=	user.getPhone();
			    sql="from UserInfo where ul_id=?";
				values=user.getUid().toString();		    
			}		
			List<UserInfo> list3=dao.query(sql, values);
			for (UserInfo userInfo : list3) {
				oldimageurl=userInfo.getImageUrl();
			}
			newimageurl=newimageurl+"ZZU"+data.GetNowDate2();//ͼƬ����account+��������
			str[0]=newimageurl;
			str[1]=phone;
			str[2]=oldimageurl;
			}
			return str;
			
		}
		
		
}
