package com.sake.user.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountCodeDao {

	//주소보기
		public List<AccountCodeDto> addressList(AccountCodeDto dto);
	//주소 추가
		public int addressInsert(AccountCodeDto dto);
	//주소 삭제
		public int addressDelete(AccountCodeDto dto);
	//대표 초기화
		public int resetrep(String seq);
	//대표 설정
		public int setrep(@Param("seq") String seq, @Param("ua_id") String ua_id);
}
