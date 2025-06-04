package com.sake.module.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	
	public MemberDto selectView(MemberDto memberdto);
	
	public int selectOneCount(MemberVo vo);
	
	public int insert(MemberDto memberdto);
	
	public int update(MemberDto memberdto);
	
	
	// user 로그인
	public MemberDto selectOneLogin(MemberDto memberdto);
	// user 벨리데이션
	public MemberDto checkid(MemberDto memberdto);
	public MemberDto checkclearance(MemberDto memberdto);
	public MemberDto checkem(MemberDto memberdto);
	public MemberDto checkpw(MemberDto memberdto);
	
	// user 계정관리
	public MemberDto accountSetting(String num);
	public int accountUpdate(MemberDto memberdto);
	// 비밀번호 변경
	public int changepw(MemberDto memberdto);
	
	// admin select 여러개 삭제
	public int uelete(@Param("userIds") List<Integer>userIds);
	
	//계정 삭제
	public int withdrawAction(String user_id);
	
//	public MemberDto findByUsername(String name);
	 //주소보기
	 public List<MemberDto> addressList(MemberDto dto);
	 //주소 추가
	 public int addressInsert(MemberDto dto);
}
