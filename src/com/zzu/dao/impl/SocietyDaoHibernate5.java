package com.zzu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zzu.dao.SocietyDao;
import com.zzu.entity.Society;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
@Repository(value="societyDaoHibernate5")
public class SocietyDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements SocietyDao<T> {

	public List<Society> query(Integer values) {
		String sql="from Society where societyid=?";
		return (List<Society>)getHibernateTemplate().find(sql, values);
	}
}
