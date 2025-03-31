package com.sake.module.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

	public List<ProductDto> selectList(ProductVo vo);
	
	public List<ProductDto> dcView();
	
	public int selectOneCount(ProductVo vo);
	
	public ProductDto selectView(ProductDto dto);
	
	public int insert(ProductDto dto);
	
	public int update(ProductDto dto);
}
