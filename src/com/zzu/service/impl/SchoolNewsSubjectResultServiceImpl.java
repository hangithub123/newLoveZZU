package com.zzu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.SchoolNewsSubjectResultDao;
import com.zzu.entity.SchoolNewsSubjectResult;
import com.zzu.service.SchoolNewsSubjectResultService;

@Transactional
@Service(value="schoolNewsSubjectResultServiceImpl")
public class SchoolNewsSubjectResultServiceImpl implements SchoolNewsSubjectResultService{

	@Resource(name="schoolNewsSubjectResultDaoHibernate5")
	private SchoolNewsSubjectResultDao schoolNewsSubjectResultDao;
	public void save(SchoolNewsSubjectResult schoolNewsSubjectResult){
		schoolNewsSubjectResultDao.save(schoolNewsSubjectResult);
	}
	public List<SchoolNewsSubjectResult> query(String queryString){
		return schoolNewsSubjectResultDao.query(queryString);
	}
}  
