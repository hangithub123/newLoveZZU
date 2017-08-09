package com.zzu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.SocietyNewsDao;
import com.zzu.entity.SocietyNews;
import com.zzu.service.SocietyNewsService;




@Transactional
@Service(value="societyNewsServiceImpl")
public class SocietyNewsServiceImpl implements SocietyNewsService{

	@Resource(name="societyNewsDaoHibernate5")
	private SocietyNewsDao societyNewsDao;
	public void save(SocietyNews societyNews){
		societyNewsDao.save(societyNews);
	}
	public List<SocietyNews> query(String News_Id){
		return societyNewsDao.query("select p from SocietyNews p where News_Id = " + News_Id);
	}
}
