package com.sake.module.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public List<ProductDto> selectList(ProductVo vo){
		return productDao.selectList(vo);
	}
	public List<ProductDto> dcView(){
		return productDao.dcView();
	}
	
	
	public int selectOneCount(ProductVo vo) {
		return productDao.selectOneCount(vo);
	}
	
	public ProductDto selectView(ProductDto dto) {
		return productDao.selectView(dto);
	}
	
	public int insert(ProductDto dto) {
		return productDao.insert(dto);
	}
	
	public int update(ProductDto dto){
		return productDao.update(dto);
	}
	
	public int uelete(List<Integer> pdIds) {
		return productDao.uelete(pdIds);
	}
}
