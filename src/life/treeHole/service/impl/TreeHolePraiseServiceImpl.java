package life.treeHole.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.treeHole.dao.TreeHolePraiseDao;
import life.treeHole.entity.TreeHolePraise;
import life.treeHole.service.TreeHolePraiseService;


@Transactional
@Service(value="treeHolePraiseServiceImpl")
public class TreeHolePraiseServiceImpl implements TreeHolePraiseService{

	@Resource(name="treeHolePraiseDaoHibernate5")
	private TreeHolePraiseDao treeHolePraiseDao;
	
   public Serializable save(TreeHolePraise treeHolePraise){
		
		return treeHolePraiseDao.save(treeHolePraise);
	}
   public List query(String sql,Object[] values){
		
		return treeHolePraiseDao.query(sql,values);
	}
   
}
