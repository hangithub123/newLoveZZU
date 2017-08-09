package persionalCenter.confessionWall.service;

import java.io.Serializable;
import java.util.List;

import persionalCenter.confessionWall.entity.BareHeart;

public interface BareHeartService {
	void update(Object entity);
	public BareHeart get(Class<BareHeart> entityClazz, Serializable id) ;
    void save(BareHeart bareHeart);
	List<BareHeart> findByPage(final int pageNo, final int pageSize );
}
