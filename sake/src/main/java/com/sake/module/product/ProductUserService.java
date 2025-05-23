package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUserService {

	@Autowired
	ProductDao dao;
	
	
	public  List<ProductDto> localDetailList(String local_detail){
		return dao.localDetailList(local_detail);
	}
	
	public  List<ProductDto> localList(String local){
		return dao.localList(local);
	}
	
	public  List<ProductDto> typeList(String type){
		return dao.typeList(type);
	}
	
	
	
	public List<ProductDto> filterProducts(FilterDto filterDto) {
        // 필터 조건을 받아 DAO로 전달하여 필터링된 상품 리스트를 가져옴
        return dao.filterProducts(filterDto);
    }

	
	
}
