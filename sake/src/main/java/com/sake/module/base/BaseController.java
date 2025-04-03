package com.sake.module.base;

import com.sake.module.product.ProductVo;
import com.sake.module.util.UtilDateTime;

public class BaseController {

	
	public void addEnd(BaseVo vo){
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}
	
}
