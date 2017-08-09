package com.zzu.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.SocietyDao;
import com.zzu.entity.Society;
import com.zzu.service.SocietyService;


@Transactional
@Service(value="societyServiceImpl")
public class SocietyServiceImpl implements SocietyService{

	@Resource(name="societyDaoHibernate5")
	private SocietyDao societyDao;
	
	public Society get(Serializable id)
	{
		return (Society)societyDao.get(Society.class, id);
	}
	public void update(Society society){
		societyDao.update(society);
	} 
	public void save(Society society){
		societyDao.save(society);
	}
	public List<Society> query(Integer values) {
		return societyDao.query(values);
	}
	public List<Society> findAll(){
		return societyDao.findAll(Society.class);
	}
	public List<Society> findByPage(
			final int pageNo, final int pageSize ){
		return societyDao.findByPage("select en from Society en", pageNo, pageSize);
	}
}
