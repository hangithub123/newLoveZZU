package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.TopicContentDao;
import life.topicCircle.entity.TopicContent;
import life.topicCircle.service.TopicContentService;



@Transactional
@Service(value="topicContentServiceImpl")
public class TopicContentServiceImpl implements TopicContentService{

	@Resource(name="topicContentDaoHibernate5")
	private TopicContentDao topicContentDao;
	public void save(TopicContent topicContent){
		topicContentDao.save(topicContent);
	}
	public void update(Object entity){
		topicContentDao.update(entity);
	}
    public List query(String sql,Object[] values){
		
		return topicContentDao.query(sql, values);
	}
	public TopicContent get(Class<TopicContent> entityClazz, Serializable id)
	{
		return (TopicContent)topicContentDao.get(entityClazz, id);
	}
}
