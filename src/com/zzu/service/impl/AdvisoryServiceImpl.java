package com.zzu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.AdvisoryDao;
import com.zzu.entity.Advisory;
import com.zzu.service.AdvisoryService;
 
@Transactional
@Service(value="advisoryServiceImpl")
public class AdvisoryServiceImpl implements AdvisoryService{

	@Resource(name="advisoryDaoHibernate5")
	private AdvisoryDao advisoryDao;
	
	public List findAll(){
		return advisoryDao.findAll(Advisory.class);
	}
	public void save(Advisory advisory){
		 advisoryDao.save(advisory);
	}
	public List<Advisory> findByPage(
			final int pageNo, final int pageSize ){
		return advisoryDao.findByPage("select en from Advisory en", pageNo, pageSize);
	}
}
