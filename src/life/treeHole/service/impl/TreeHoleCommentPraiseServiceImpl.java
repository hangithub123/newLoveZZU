package life.treeHole.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.treeHole.dao.TreeHoleCommentPraiseDao;
import life.treeHole.entity.TreeHoleCommentPraise;
import life.treeHole.service.TreeHoleCommentPraiseService;

 

@Transactional
@Service(value="treeHoleCommentPraiseServiceImpl")
public class TreeHoleCommentPraiseServiceImpl implements TreeHoleCommentPraiseService{

	@Resource(name="treeHoleCommentPraiseDaoHibernate5")
	private TreeHoleCommentPraiseDao treeHoleCommentPraiseDao;
	
   public Serializable save(TreeHoleCommentPraise treeHoleCommentPraise){
		
		return treeHoleCommentPraiseDao.save(treeHoleCommentPraise);
	}
   public List query(String sql,Object[] values){
		
		return treeHoleCommentPraiseDao.query(sql,values);
	}
}
