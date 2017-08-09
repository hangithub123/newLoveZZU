package com.zzu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.dao.SocietyNewsDao;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
@Repository(value="societyNewsDaoHibernate5")
public class SocietyNewsDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements SocietyNewsDao<T> {

}
