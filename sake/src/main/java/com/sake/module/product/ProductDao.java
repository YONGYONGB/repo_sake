package com.sake.module.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sake.module.base.BaseDao;
import com.sake.module.base.BaseDto;

@Repository
public interface ProductDao extends BaseDao{

	public List<ProductDto> selectList(ProductVo vo);
	public List<ProductDto> localcheck(String cd_id);
	
	public List<ProductDto> dcView();
	
	public int selectOneCount(ProductVo vo);
	
	public ProductDto selectView(ProductDto dto);
	
	public int insert(ProductDto dto);
	
	public int update(ProductDto dto);
	
	public int uelete(@Param("pdIds") List<Integer> pdIds);
	
	
	
	public ProductDto menu(ProductDto dto);
	
	public List<ProductDto> localcheck(ProductDto dto);
	
	
	///  유저
	
	public  List<ProductDto> localDetailList(@Param("local_detail") int local_detail, @Param("vo")ProductVo vo);
	
	public int countlocalList(@Param("local") int local, @Param("vo")ProductVo vo);
	
	
	public  List<ProductDto> localList(@Param("local")int local, @Param("vo") ProductVo vo);
	
	public int countlocalDetailList(@Param("local_detail")int local_detail, @Param("vo") ProductVo vo);
	
	
	
	public  List<ProductDto> typeList(@Param("type")int type, @Param("vo") ProductVo vo);
	
	public int counttypeList(@Param("type")int type, @Param("vo") ProductVo vo);
	
	
	public int filterProductCount(FilterDto filterDTO);
	
	
	public List<ProductDto> filterProducts(FilterDto filterDto); 
	
	public int urlcount(String pseq);
}
