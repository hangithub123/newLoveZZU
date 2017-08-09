package com.zzu.dao.impl;

import org.springframework.stereotype.Repository;

import com.zzu.dao.CarouselDao;

import life.treeHole.common.dao.impl.BaseDaoHibernate5;
@Repository(value="carouselDaoHibernate5")
public class CarouselDaoHibernate5 <T> extends BaseDaoHibernate5<T> implements CarouselDao<T> {

}
