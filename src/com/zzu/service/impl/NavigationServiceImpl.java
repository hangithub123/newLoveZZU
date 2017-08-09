package com.zzu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.NavigationDao;
import com.zzu.entity.Navigation;
import com.zzu.service.NavigationService;

@Transactional
@Service(value="navigationServiceImpl")
public class NavigationServiceImpl implements NavigationService{

	@Resource(name="navigationDaoHibernate5")
	private NavigationDao navigationDao;
	public void save(Navigation navigation){
		navigationDao.save(navigation);
	}
	public List<Navigation> findAll(){
		return navigationDao.findAll(Navigation.class);
	}
}
