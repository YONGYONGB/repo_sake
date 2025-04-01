package com.sake.module.discount;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sake.module.code.CodeVo;

@Repository
public interface DiscountDao {

	public List<DiscountDto> selectList(DiscountVo vo);
	
	public int selectOneCount(DiscountVo vo);
	
	public DiscountDto selectView(DiscountDto discountdto);
	
	public int insert(DiscountDto discountdto);
	
	public int update(DiscountDto discountdto);
	
}
