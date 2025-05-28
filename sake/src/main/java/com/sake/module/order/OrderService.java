package com.sake.module.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;
	
	public int Uoinsert(OrderDto dto) {
		return dao.Uoinsert(dto);
	}
	
	public int Opinsert(String cart_id, String userOrder_od_id) {
		return dao.Opinsert(cart_id, userOrder_od_id);
	}
	
	public List<String> findUserUoseq(String user_user_id){
		return dao.findUserUoseq(user_user_id);
	}
	public List<OrderDto> findOpList(List<String>odIdList){
		return dao.findOpList(odIdList);
	}
	
}
