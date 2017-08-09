package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.Subject;

public interface SubjectService {
	 void save(Subject subject);
	 void update(Object entity);
     List query(String sql,Object[] values);
	 Subject get(Class<Subject> entityClazz, Serializable id);
	 List<Subject> findByPage(final int pageNo, final int pageSize );
}
