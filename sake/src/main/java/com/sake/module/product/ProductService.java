package com.sake.module.product;

import java.text.Normalizer;
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
	public List<ProductDto> localcheck(String cd_id) {
	    return productDao.localcheck(cd_id);
	}
	
	public int selectOneCount(ProductVo vo) {
		return productDao.selectOneCount(vo);
	}
	
	public ProductDto selectView(ProductDto dto) {
		return productDao.selectView(dto);
	}
	
	public int insert(ProductDto dto) {
		 if (dto.getName() != null) {
	            // 유니코드 정규화 (NFC 형태로)
	            String normalizedName = Normalizer.normalize(dto.getName(), Normalizer.Form.NFC);
	            dto.setName(normalizedName);;
	        }
		return productDao.insert(dto);
	}
	
	public int update(ProductDto dto){
		if (dto.getName() != null) {
            // 유니코드 정규화 (NFC 형태로)
            String normalizedName = Normalizer.normalize(dto.getName(), Normalizer.Form.NFC);
            dto.setName(normalizedName);;
        }
		return productDao.update(dto);
	}
	
	public int uelete(List<Integer> pdIds) {
		return productDao.uelete(pdIds);
	}
	
	public ProductDto menu(ProductDto dto){
		return productDao.menu(dto);
	}
}
