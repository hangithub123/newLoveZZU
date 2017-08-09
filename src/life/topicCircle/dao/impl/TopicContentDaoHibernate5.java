package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.TopicContentDao;
@Repository(value="topicContentDaoHibernate5")
public class TopicContentDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TopicContentDao<T> {

}
