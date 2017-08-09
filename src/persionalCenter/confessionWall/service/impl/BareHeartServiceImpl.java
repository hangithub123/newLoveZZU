package persionalCenter.confessionWall.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persionalCenter.confessionWall.dao.BareHeartDao;
import persionalCenter.confessionWall.entity.BareHeart;
import persionalCenter.confessionWall.service.BareHeartService;

@Transactional
@Service(value="bareHeartServiceImpl")
public class BareHeartServiceImpl implements BareHeartService{

	@Resource(name="bareHeartDaoHibernate5")
	private BareHeartDao bareHeartDao;
	@Override
	public BareHeart get(Class<BareHeart> entityClazz, Serializable id) {
		return (BareHeart)bareHeartDao.get(entityClazz, id);
	}
	@Override
	public void save(BareHeart bareHeart){
		bareHeartDao.save(bareHeart);
	}
	@Override
	public List<BareHeart> findByPage(
			final int pageNo, final int pageSize ){
		//"select en en.userInfo.imageUrl en.userInfo.nickname from BareHeart en"
		return bareHeartDao.findByPage("select en from BareHeart en", pageNo, pageSize);
	}
	@Override
	public void update(Object entity) { 
		
		bareHeartDao.update(entity);
	}
	
}
