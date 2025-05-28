package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUserService {

	@Autowired
	ProductDao dao;
	
	
	public  List<ProductDto> localDetailList(int local_detail,ProductVo vo){
		return dao.localDetailList(local_detail,vo);
	}
	
	public int countlocalList(int local_detail, ProductVo vo) {
		return dao.countlocalList(local_detail, vo);
	}
	
	public  List<ProductDto> localList(int local, ProductVo vo){
		return dao.localList(local, vo);
	}
	
	public int countlocalDetailList(int local, ProductVo vo) {
		return dao.countlocalDetailList(local, vo);
	}
	
	public  List<ProductDto> typeList(int type,ProductVo vo){
		return dao.typeList(type,vo);
	}
	
	public int counttypeList(int type,ProductVo vo) {
		return dao.counttypeList(type, vo);
	}
	
	
	public List<ProductDto> filterProducts(FilterDto filterDto) {
        // 필터 조건을 받아 DAO로 전달하여 필터링된 상품 리스트를 가져옴
        return dao.filterProducts(filterDto);
    }

	
	
}
