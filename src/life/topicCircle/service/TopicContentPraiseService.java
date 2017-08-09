package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.TopicContentPraise;

public interface TopicContentPraiseService {
     Serializable save(TopicContentPraise topicContentPraise);
     List query(String sql,Object[] values);
}
