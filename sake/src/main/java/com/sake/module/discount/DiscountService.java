package com.sake.module.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sake.module.code.CodeVo;

@Service
public class DiscountService {

	@Autowired
	DiscountDao discountDao;
	
	public List<DiscountDto> selectList(DiscountVo vo){
		return discountDao.selectList(vo);
	}
	
	public int selectOneCount(DiscountVo vo){
		return discountDao.selectOneCount(vo);
	}
	
	
	public DiscountDto selectView(DiscountDto discountdto) {
		return discountDao.selectView(discountdto);
	}
	
	public int insert(DiscountDto discountdto) {
		return discountDao.insert(discountdto);
	}
	
	public int update(DiscountDto discountdto) {
		return discountDao.update(discountdto);
	}
}
