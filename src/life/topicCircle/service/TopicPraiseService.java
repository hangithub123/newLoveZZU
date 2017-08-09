package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.TopicPraise;

public interface TopicPraiseService {
    Serializable save(TopicPraise topicPraise);
    List query(String sql,Object[] values);
}
