package life.treeHole.dao.impl;

import org.springframework.stereotype.Repository;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
import life.treeHole.dao.TreeHoleCommentPraiseDao;
@Repository(value="treeHoleCommentPraiseDaoHibernate5")
public class TreeHoleCommentPraiseDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements TreeHoleCommentPraiseDao<T> {

}
