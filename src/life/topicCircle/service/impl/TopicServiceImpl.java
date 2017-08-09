package life.topicCircle.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.topicCircle.dao.TopicDao;
import life.topicCircle.entity.Topic;
import life.topicCircle.service.TopicService;



@Transactional
@Service(value="topicServiceImpl")
public class TopicServiceImpl implements TopicService{

	@Resource(name="topicDaoHibernate5")
	private TopicDao topicDao;
	public void save(Topic topic){
		topicDao.save(topic);
	}
	public void update(Object entity){
		topicDao.update(entity);
	}
    public List query(String sql,Object[] values){
		
		return topicDao.query(sql, values);
	}
	public Topic get(Class<Topic> entityClazz, Serializable id)
	{
		return (Topic)topicDao.get(entityClazz, id); 
	}
	public List<Topic> findByPage(
			final int pageNo, final int pageSize ){
		System.out.println("select en from Topic en");
		//"select en en.userInfo.imageUrl en.userInfo.nickname from BareHeart en"
		return topicDao.findByPage("select en from Topic en", pageNo, pageSize);
	}
	
}
