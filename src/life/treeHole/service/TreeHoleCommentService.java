package life.treeHole.service;

import java.io.Serializable;
import java.util.List;

import life.treeHole.entity.TreeHoleComment;

public interface TreeHoleCommentService {
	 void save(TreeHoleComment treeHoleComment);
	 TreeHoleComment get(Class<TreeHoleComment> entityClazz, Serializable id);
	 List query(String sql,Object[] values);
	 List<TreeHoleComment> findByPage(final int pageNo, final int pageSize );
	 void update(Object entity);
}
