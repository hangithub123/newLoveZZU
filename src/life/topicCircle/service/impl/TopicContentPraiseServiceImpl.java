package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.TopicContentPraiseDao;
import life.topicCircle.entity.TopicContentPraise;
import life.topicCircle.service.TopicContentPraiseService;




@Transactional
@Service(value="topicContentPraiseServiceImpl")
public class TopicContentPraiseServiceImpl implements TopicContentPraiseService{
	@Resource(name="topicContentPraiseDaoHibernate5")
	private TopicContentPraiseDao topicContentPraiseDao;
	
    public Serializable save(TopicContentPraise topicContentPraise){
		
		return topicContentPraiseDao.save(topicContentPraise);
	}
    public List query(String sql,Object[] values){
		
		return topicContentPraiseDao.query(sql,values);
	}
}
