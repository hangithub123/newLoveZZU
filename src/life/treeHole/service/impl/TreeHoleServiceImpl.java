package life.treeHole.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import life.treeHole.dao.TreeHoleDao;
import life.treeHole.entity.TreeHole;
import life.treeHole.service.TreeHoleService;


@Transactional
@Service(value="treeHoleServiceImpl")
public class TreeHoleServiceImpl implements TreeHoleService{

	@Resource(name="treeHoleDaoHibernate5")
	private TreeHoleDao treeHoleDao;
	//public List<BareHeart> findAll(){
	//	return bareHeartDao.findAll(BareHeart.class);
	//}
	public void save(TreeHole treeHole){
		treeHoleDao.save(treeHole);
	}
	public void update(Object entity){
		treeHoleDao.update(entity);
	}
    public List query(String sql,Object[] values){
		
		return treeHoleDao.query(sql, values);
	}
	public TreeHole get(Class<TreeHole> entityClazz, Serializable id)
	{
		return (TreeHole)treeHoleDao.get(entityClazz, id);
	}
	public List<TreeHole> findByPage(
			final int pageNo, final int pageSize ){
		System.out.println("select en from TreeHole en");
		//"select en en.userInfo.imageUrl en.userInfo.nickname from BareHeart en"
		return treeHoleDao.findByPage("select en from TreeHole en", pageNo, pageSize);
	}
}
