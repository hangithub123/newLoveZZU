package life.treeHole.service;

import java.io.Serializable;
import java.util.List;

import life.treeHole.entity.TreeHoleCommentPraise;

public interface TreeHoleCommentPraiseService {
    Serializable save(TreeHoleCommentPraise treeHoleCommentPraise);
    List query(String sql,Object[] values);
}
