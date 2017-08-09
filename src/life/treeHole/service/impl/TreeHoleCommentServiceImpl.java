package life.treeHole.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.treeHole.dao.TreeHoleCommentDao;
import life.treeHole.entity.TreeHoleComment;
import life.treeHole.service.TreeHoleCommentService;



@Transactional
@Service(value="treeHoleCommentServiceImpl")
public class TreeHoleCommentServiceImpl implements TreeHoleCommentService{
	@Resource(name="treeHoleCommentDaoHibernate5")
	private TreeHoleCommentDao treeHoleCommentDao;
	//public List<BareHeart> findAll(){
	//	return bareHeartDao.findAll(BareHeart.class);
	//} 
	public void save(TreeHoleComment treeHoleComment){
		treeHoleCommentDao.save(treeHoleComment);
	}
	public TreeHoleComment get(Class<TreeHoleComment> entityClazz, Serializable id)
	{        System.out.println("TreeHoleComment");
		return (TreeHoleComment)treeHoleCommentDao.get(entityClazz, id);
	}
	 public List query(String sql,Object[] values){
			
			return treeHoleCommentDao.query(sql, values);
		}
	public List<TreeHoleComment> findByPage(
			final int pageNo, final int pageSize ){
		//"select en en.userInfo.imageUrl en.userInfo.nickname from BareHeart en"
		return treeHoleCommentDao.findByPage("select en from TreeHoleComment en", pageNo, pageSize);
	}
	public void update(Object entity){
		treeHoleCommentDao.update(entity);
	}
}
