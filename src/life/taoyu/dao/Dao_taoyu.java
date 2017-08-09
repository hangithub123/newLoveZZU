package life.taoyu.dao;

import java.util.List;



public interface Dao_taoyu {
	//HQL¸üÐÂ²Ù×÷
	public <T,S> List<T> hqlquery(String sql,S action,int num);
	public <T> List<T> adminhqlquery(String sql);
}
