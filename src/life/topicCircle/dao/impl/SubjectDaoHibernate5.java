package life.topicCircle.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.common.dao.impl.BaseDaoHibernate5;

import life.topicCircle.dao.SubjectDao;
@Repository(value="subjectDaoHibernate5")
public class SubjectDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements SubjectDao<T> {

}
