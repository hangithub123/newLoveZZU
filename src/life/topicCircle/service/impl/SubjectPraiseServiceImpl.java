package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.SubjectPraiseDao;
import life.topicCircle.entity.SubjectPraise;
import life.topicCircle.service.SubjectPraiseService;



  

@Transactional
@Service(value="subjectPraiseServiceImpl")
public class SubjectPraiseServiceImpl implements SubjectPraiseService{

	@Resource(name="subjectPraiseDaoHibernate5")
	private SubjectPraiseDao subjectPraiseDao;
	
   public Serializable save(SubjectPraise subjectPraise){
		
		return subjectPraiseDao.save(subjectPraise);
	}
   public List query(String sql,Object[] values){
		
		return subjectPraiseDao.query(sql,values);
	}
   
}
