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
	
	
}
