package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.SubjectDao;
import life.topicCircle.entity.Subject;
import life.topicCircle.service.SubjectService;



@Transactional
@Service(value="subjectServiceImpl")
public class SubjectServiceImpl implements SubjectService{

	@Resource(name="subjectDaoHibernate5")
	private SubjectDao subjectDao;
	public void save(Subject subject){
		subjectDao.save(subject);
	}
	public void update(Object entity){
		subjectDao.update(entity);
	}
    public List query(String sql,Object[] values){
		
		return subjectDao.query(sql, values);
	}
	public Subject get(Class<Subject> entityClazz, Serializable id)
	{
		return (Subject)subjectDao.get(entityClazz, id);
	}
	public List<Subject> findByPage(
			final int pageNo, final int pageSize ){
		System.out.println("select en from Subject en");
		//"select en en.userInfo.imageUrl en.userInfo.nickname from BareHeart en"
		return subjectDao.findByPage("select en from Subject en", pageNo, pageSize);
	}
}
