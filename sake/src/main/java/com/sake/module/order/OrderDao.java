package com.sake.module.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao{

	//orderid
	public int Uoinsert(OrderDto dto);
	
	
	public int Opinsert(@Param("cart_id") String cart_id, @Param("userOrder_od_id") String userOrder_od_id);
	
	
	//해당유저에 따른 od_id 리스트 찾기.
	public List<String> findUserUoseq(String user_user_id);
	
	public List<OrderDto> findOpList(@Param("odIdList") List<String>odIdList);
	
	public int getPCount(@Param("odIdList") List<String>odIdList);
}
