package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.TopicContent;

public interface TopicContentService {

	 void save(TopicContent topicContent);
	 void update(Object entity);
     List query(String sql,Object[] values);
	 TopicContent get(Class<TopicContent> entityClazz, Serializable id);
}
