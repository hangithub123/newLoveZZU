package life.topicCircle.service;

import java.io.Serializable;
import java.util.List;

import life.topicCircle.entity.SubjectPraise;

public interface SubjectPraiseService {
    Serializable save(SubjectPraise subjectPraise);
    List query(String sql,Object[] values);
}
