package com.sake.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> selectList(MemberVo vo){
		return memberDao.selectList(vo);
	}
	public MemberDto selectView(MemberDto memberdto){
		return memberDao.selectView(memberdto);
	}
	

	public int selectOneCount() {
		return memberDao.selectOneCount();
	}
	
	public int insert(MemberDto memberdto) {
		return memberDao.insert(memberdto);
	}


	public int update(MemberDto memberdto) {
		return memberDao.update(memberdto);
	}
}
