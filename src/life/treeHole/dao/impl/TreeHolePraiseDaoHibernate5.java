package life.treeHole.dao.impl;

import org.springframework.stereotype.Repository;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
import life.treeHole.dao.TreeHolePraiseDao;
@Repository(value="treeHolePraiseDaoHibernate5")
public class TreeHolePraiseDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TreeHolePraiseDao<T> {

}
