package life.parTime.dao;

import java.util.List;

import com.zzu.common.dao.BaseDao;

import life.parTime.entity.PartTimeJob;
public interface PartTimeJobDao extends BaseDao<PartTimeJob>{
	public Object findPartTimeJobById(Integer id);
	
	public List<?> findPartTimeJobByPhone(String phone);
	
	public List<?> findAll();
	
	public List<?> findPartTimeJobByIdentifier(int identifier);
} 
