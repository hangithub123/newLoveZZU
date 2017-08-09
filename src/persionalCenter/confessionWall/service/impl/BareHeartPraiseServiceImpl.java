package persionalCenter.confessionWall.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persionalCenter.confessionWall.dao.BareHeartPraiseDao;
import persionalCenter.confessionWall.entity.BareHeartPraise;
import persionalCenter.confessionWall.service.BareHeartPraiseService;
@Transactional
@Service(value="bareHeartPraiseServiceImpl")
public class BareHeartPraiseServiceImpl implements BareHeartPraiseService {

	@Resource(name="bareHeartPraiseDaoHibernate5")
	private BareHeartPraiseDao bareHeartPraiseDao;
	
    public Serializable save(BareHeartPraise bareHeartPraise){
		
		return bareHeartPraiseDao.save(bareHeartPraise);
	}
    public List query(String sql,Object[] values){
		
		return bareHeartPraiseDao.query(sql,values);
	}
}
