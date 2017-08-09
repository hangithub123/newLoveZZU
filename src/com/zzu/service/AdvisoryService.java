package com.zzu.service;

import java.util.List;

import com.zzu.entity.Advisory;

public interface AdvisoryService {
	 List findAll();
	 void save(Advisory advisory);
	 List<Advisory> findByPage(final int pageNo, final int pageSize );
}
