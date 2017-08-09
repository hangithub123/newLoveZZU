package life.taoyu.dao;




import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import life.taoyu.entity.Goods;
@Repository(value="taoyuDao")
public class TaoyuDao<T> implements Dao_taoyu {

	
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	//分页查询
	@SuppressWarnings("unchecked")
	public <T,S> List<T> hqlquery(String sql,S values, int num) {
		 
		List<T> goodslist=(List<T>) this.hibernateTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query =session.createQuery(sql);
				query.setParameter(0, values);
				
				query.setFirstResult(num);
				query.setMaxResults(10);
				
			List<T> list= query.list();
			if(list.size()==0){System.out.println("已经没有数据可查了");}
			System.out.println("Test:"+list.size());
			
				return list;
			}
		});
		return goodslist;
  		  
		
	}
	public  List<T> adminhqlquery(String sql) {
		
		@SuppressWarnings("unchecked")
		List<T> goodslist=(List<T>) this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query =session.createQuery(sql);
				
				
				List<T> list= query.list();
				if(list.size()==0){System.out.println("已经没有数据可查了");}
				System.out.println("Test:"+list.size());
				
				return list;
			}
		});
		return goodslist;
		
		
		
	}

}
