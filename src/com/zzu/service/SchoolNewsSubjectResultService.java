package com.zzu.service;

import java.util.List;

import com.zzu.entity.SchoolNewsSubjectResult;

public interface SchoolNewsSubjectResultService {
	 void save(SchoolNewsSubjectResult schoolNewsSubjectResult);
	 List<SchoolNewsSubjectResult> query(String queryString);
}
