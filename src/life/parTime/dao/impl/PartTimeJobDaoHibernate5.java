package life.parTime.dao.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.parTime.dao.PartTimeJobDao;
import life.parTime.entity.PartTimeJob;
@Repository(value="partTimeJobDaoHibernate5")
public class PartTimeJobDaoHibernate5 extends BaseDaoHibernate5<PartTimeJob> implements PartTimeJobDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public Object findPartTimeJobById(Integer id) {
		String sql="SELECT id,content,identifier,phone,publish_date,title from PartTimeJob where id=?";
		Object ob=hibernateTemplate.find(sql, id).get(0);
		return ob;
	}
	
	public List<?> findPartTimeJobByPhone(String phone){
		String sql="SELECT id,content,identifier,phone,publish_date,title from PartTimeJob where phone=?";
		List<?> list= hibernateTemplate.find(sql, phone);
		return list;
	}
	
	public List<?> findAll(){
		String sql="SELECT id,content,identifier,phone,publish_date,title from PartTimeJob";
		List<?> list=hibernateTemplate.find(sql,null);
		return list;
		
	}

	public List<?> findPartTimeJobByIdentifier(int identifier) {
		String sql="SELECT id,content,identifier,phone,publish_date,title from PartTimeJob where identifier=?";
		List<?> list= hibernateTemplate.find(sql, identifier);
		return list;
	}

} 
 