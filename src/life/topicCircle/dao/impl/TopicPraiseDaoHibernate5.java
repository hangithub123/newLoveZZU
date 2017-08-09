package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.TopicPraiseDao;
@Repository(value="topicPraiseDaoHibernate5")
public class TopicPraiseDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TopicPraiseDao<T> {

}
