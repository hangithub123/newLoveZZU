package life.treeHole.service;

import java.io.Serializable;
import java.util.List;

import life.treeHole.entity.TreeHole;

public interface TreeHoleService {
	 void save(TreeHole treeHole);
	 void update(Object entity);
     List query(String sql,Object[] values);
	 TreeHole get(Class<TreeHole> entityClazz, Serializable id);
	 List<TreeHole> findByPage(final int pageNo, final int pageSize );
}
