package com.zzu.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import life.treeHole.common.dao.BaseDao;

import org.hibernate.*;

public class BaseDaoHibernate5 <T> implements BaseDao<T> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return hibernateTemplate.get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return hibernateTemplate.save(entity);
	}

	@Override
	public void update(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));	
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		
		return (List<T>)hibernateTemplate.find("select en from " + entityClazz.getSimpleName() + " en");
	}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录 
	 */
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize) {
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = hibernateTemplate
			.execute(new HibernateCallback<List<T>>()
		{
			// 实现HibernateCallback接口必须实现的方法
			public List<T> doInHibernate(Session session)
			{
				// 执行Hibernate分页查询
				List<T> result = session.createQuery(hql)
					.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
	/** 
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @param params 如果hql带占位符参数，params用于传入占位符参数
	 * @return 当前页的所有记录
	 */
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		// 通过一个HibernateCallback对象来执行查询
		List<T> list = hibernateTemplate
			.execute(new HibernateCallback<List<T>>()
		{
			// 实现HibernateCallback接口必须实现的方法
			public List<T> doInHibernate(Session session)
			{
				// 执行Hibernate分页查询
				Query query = session.createQuery(hql);
				// 为包含占位符的HQL语句设置参数
				for(int i = 0 , len = params.length ; i < len ; i++)
				{
					query.setParameter(i + "" , params[i]);
				}
				List<T> result = query.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
	@Override
	public List query(String sql, Object[] values) {
		
		return (List)hibernateTemplate.find(sql, values);
	}
	@Override
	public List<T> query(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
}
