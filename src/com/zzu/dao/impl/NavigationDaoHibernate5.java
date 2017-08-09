package com.zzu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.dao.NavigationDao;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
@Repository(value="navigationDaoHibernate5")
public class NavigationDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements NavigationDao<T> {

}
