package persionalCenter.confessionWall.dao.impl;

import org.springframework.stereotype.Repository;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
import persionalCenter.confessionWall.dao.BareHeartDao;
@Repository(value="bareHeartDaoHibernate5")
public class BareHeartDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements BareHeartDao<T> {

}
