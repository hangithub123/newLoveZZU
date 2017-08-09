package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.SubjectPraiseDao;
@Repository(value="subjectPraiseDaoHibernate5")
public class SubjectPraiseDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements SubjectPraiseDao<T> {

}
