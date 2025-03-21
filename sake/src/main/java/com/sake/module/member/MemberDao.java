package com.sake.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	
	public MemberDto selectView(MemberDto memberdto);
	
	public int selectOneCount();
	
	public int insert(MemberDto memberdto);
	
	public int update(MemberDto memberdto);
}
