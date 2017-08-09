package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.TopicContentPraiseDao;
@Repository(value="topicContentPraiseDaoHibernate5")
public class TopicContentPraiseDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TopicContentPraiseDao<T> {

}
