package life.treeHole.dao.impl;

import org.springframework.stereotype.Repository;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
import life.treeHole.dao.TreeHoleDao;
@Repository(value="treeHoleDaoHibernate5")
public class TreeHoleDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TreeHoleDao<T> {

}
