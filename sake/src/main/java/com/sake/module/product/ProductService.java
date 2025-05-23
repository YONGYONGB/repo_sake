package com.sake.module.product;

import java.text.Normalizer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.sake.module.base.BaseDao;
import com.sake.module.base.BaseService;

@Service
public class ProductService extends BaseService{
	
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	BaseDao dao;
	
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
	
	public int insert(ProductDto dto) throws Exception{
		 if (dto.getName() != null) {
	            // 유니코드 정규화 (NFC 형태로)
	            String normalizedName = Normalizer.normalize(dto.getName(), Normalizer.Form.NFC);
	            dto.setName(normalizedName);;
	        }
		productDao.insert(dto);
		uploadFilesToS3(
    			dto
    			, "productUploaded"
    			, dto.getType()
    			, dto.getPd_id()
    			, dao
    			, amazonS3Client);
    	return 1; 
	}
	
	
	
	
	public int update(ProductDto dto) throws Exception{
		if (dto.getName() != null) {
            // 유니코드 정규화 (NFC 형태로)
            String normalizedName = Normalizer.normalize(dto.getName(), Normalizer.Form.NFC);
            dto.setName(normalizedName);;
        }
		productDao.update(dto);
		uploadFilesToS3(
    			dto
    			, "productUploaded"
    			, dto.getType()
    			, dto.getPd_id()
    			, dao
    			, amazonS3Client);
    	return 1; 
	}
	
	public int uelete(List<Integer> pdIds) {
		return productDao.uelete(pdIds);
	}
	
	public ProductDto menu(ProductDto dto){
		return productDao.menu(dto);
	}
}
