package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.Topic;

public interface TopicService {
	 void save(Topic topic);
	 void update(Object entity);
     List query(String sql,Object[] values);
     Topic get(Class<Topic> entityClazz, Serializable id);
	 List<Topic> findByPage(final int pageNo, final int pageSize );
	
}
