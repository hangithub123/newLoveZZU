package life.parTime.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzu.dao.AdvisoryDao;
import com.zzu.entity.Advisory;
import com.zzu.service.AdvisoryService;

import life.parTime.dao.PartTimeJobDao;
import life.parTime.entity.PartTimeJob;
import life.parTime.service.PartTimeJobService;
 
@Transactional
@Service(value="partTimeJobServiceImpl")
public class PartTimeJobServiceImpl implements PartTimeJobService{

	@Resource(name="partTimeJobDaoHibernate5")
	private PartTimeJobDao partTimeJobDao;
	
	
	public void save(PartTimeJob partTimeJob){
		partTimeJobDao.save(partTimeJob);
	}


	public Object findPartTimeJobById(Integer id) {
		return partTimeJobDao.findPartTimeJobById(id);
	}


	public List<?> findPartTimeJobByPhone(String phone) {
		return partTimeJobDao.findPartTimeJobByPhone(phone);
	}


	public List<?> findAll() {
		return partTimeJobDao.findAll();
	}


	public List<?> findPartTimeJobByIdentifier(int identifier) {
		return partTimeJobDao.findPartTimeJobByIdentifier(identifier);
	}
	
}
