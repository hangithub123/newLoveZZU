package life.treeHole.service;

import java.io.Serializable;
import java.util.List;

import life.treeHole.entity.TreeHolePraise;

public interface TreeHolePraiseService {
    Serializable save(TreeHolePraise treeHolePraise);
    List query(String sql,Object[] values);
}
