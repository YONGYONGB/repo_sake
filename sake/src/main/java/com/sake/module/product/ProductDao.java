package com.sake.module.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

	public List<ProductDto> selectList(ProductVo vo);
	
	public int selectOneCount(ProductVo vo);
}
