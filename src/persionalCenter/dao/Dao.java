package persionalCenter.dao;

import java.io.Serializable;
import java.util.List;



public interface Dao {

	//保存操作
	public <T> Serializable save(T t);
	//查询操作
	public <T> List<T> query(String sql,String values1,String values2);
	public <T,S> List<T> query(String sql,S values);
	//更新操作
	public <T> T update(T t);
	//删除操作
	public <T> void delete(T t);

}
