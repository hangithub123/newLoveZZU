package com.zzu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.dao.SchoolNewsSubjectResultDao;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
@Repository(value="schoolNewsSubjectResultDaoHibernate5")
public class SchoolNewsSubjectResultDaoHibernate5<T> extends BaseDaoHibernate5<T>
		implements SchoolNewsSubjectResultDao<T> {
	

}
