package com.zzu.dao;

import java.io.Serializable;
import java.util.List;



public interface Dao {

	//保存操作
	public <T> Serializable save(T t);
	//查询操作
	public <T> List<T> query(String sql,String values);
	//更新操作
	public <T> T update(T t);
}
