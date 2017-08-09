package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.TopicPraiseDao;
import life.topicCircle.entity.TopicPraise;
import life.topicCircle.service.TopicPraiseService;




@Transactional
@Service(value="topicPraiseServiceImpl")
public class TopicPraiseServiceImpl implements TopicPraiseService{


	@Resource(name="topicPraiseDaoHibernate5")
	private TopicPraiseDao topicPraiseDao;
	
   public Serializable save(TopicPraise topicPraise){
		
		return topicPraiseDao.save(topicPraise);
	}
   public List query(String sql,Object[] values){
		
		return topicPraiseDao.query(sql,values);
	}
}
