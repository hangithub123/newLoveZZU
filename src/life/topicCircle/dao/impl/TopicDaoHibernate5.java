package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.TopicDao;
@Repository(value="topicDaoHibernate5")
public class TopicDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TopicDao<T> {

}
