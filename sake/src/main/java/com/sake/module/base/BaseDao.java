package com.sake.module.base;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface BaseDao {

	public int insertUploaded(BaseDto dto);
	
	public int updateUploaded(BaseDto dto);
}
