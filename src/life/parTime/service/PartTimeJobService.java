package life.parTime.service;

import java.util.List;

import life.parTime.entity.PartTimeJob;

public interface PartTimeJobService {
	 
	 public void save(PartTimeJob partTimeJob);
	 
	 public Object findPartTimeJobById(Integer id);
	 
	 public List<?> findPartTimeJobByPhone(String phone);
		
	 public List<?> findAll();
	 
	 public List<?> findPartTimeJobByIdentifier(int identifier);
	 
	 
	 
}
