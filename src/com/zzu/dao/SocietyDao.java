package com.zzu.dao;

import java.util.List;

import com.zzu.entity.Society;

import life.treeHole.common.dao.BaseDao;

public interface SocietyDao <T> extends BaseDao<T> {

	public List<Society> query(Integer values);
}
