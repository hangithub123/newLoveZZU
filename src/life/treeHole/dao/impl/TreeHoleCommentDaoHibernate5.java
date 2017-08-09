package life.treeHole.dao.impl;

import org.springframework.stereotype.Repository;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
import life.treeHole.dao.TreeHoleCommentDao;
@Repository(value="treeHoleCommentDaoHibernate5")
public class TreeHoleCommentDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TreeHoleCommentDao<T> {

}
