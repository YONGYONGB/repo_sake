package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUserService {

	@Autowired
	ProductDao dao;
	
	public List<ProductDto> localcheck(ProductDto dto){
		return dao.localcheck(dto);
	}
}
