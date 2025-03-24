package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public List<ProductDto> selectList(ProductVo productVo){
		return productDao.selectList(productVo);
	}
	
	public int selectOneCount() {
		return productDao.selectOneCount();
	}
}
