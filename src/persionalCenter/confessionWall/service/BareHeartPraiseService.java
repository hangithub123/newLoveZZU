package persionalCenter.confessionWall.service;

import java.io.Serializable;
import java.util.List;

import persionalCenter.confessionWall.entity.BareHeartPraise;

public interface BareHeartPraiseService {

	    public Serializable save(BareHeartPraise bareHeartPraise);
	    public List query(String sql,Object[] values);
}
