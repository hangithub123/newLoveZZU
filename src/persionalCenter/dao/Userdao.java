package persionalCenter.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;



@Repository(value="user_Dao")
public class Userdao implements Dao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	   

	boolean isSuccessful=false;
	String[] userinfoDatas=new String[9];
	
	//保存用户并返回id
	public <T> Serializable save(T t) {
		Serializable id=null;
		hibernateTemplate.clear();
		 id=hibernateTemplate.save(t);
		 hibernateTemplate.flush();
		return id;
	}
	//查询用户并返回用户对象
	@SuppressWarnings("unchecked")
	public <T> List<T> query(String sql, String values1,String values2) {
		List<T> list = new ArrayList<T>();
		hibernateTemplate.clear();
		hibernateTemplate.flush();
		list.clear();
	
		 list=(List<T>) hibernateTemplate.find(sql, values1,values2);
		
		hibernateTemplate.flush();
		
		return list;
	}
	@SuppressWarnings("unchecked")
	public <T, S> List<T> query(String sql, S values) {
		List<T> list = new ArrayList<T>();
		hibernateTemplate.clear();
		hibernateTemplate.flush();
		list.clear();
		
		list=(List<T>) hibernateTemplate.find(sql, values);
		
		hibernateTemplate.flush();
		
		return list;
	}
	//更新操作
	@Override
	public <T> T update(T t) {
		hibernateTemplate.clear();
		hibernateTemplate.update(t);
		hibernateTemplate.flush();
	
		return null;
	}
	//删除操作
	@Override
	public <T> void delete(T t) {
		hibernateTemplate.clear();
		hibernateTemplate.delete(t);
		hibernateTemplate.flush();
		
	}

	
	

	
}
