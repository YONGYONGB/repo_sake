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
	

	public int selectOneCount(MemberVo vo) {
		return memberDao.selectOneCount(vo);
	}
	
	public int insert(MemberDto memberdto) {
		return memberDao.insert(memberdto);
	}


	public int update(MemberDto memberdto) {
		return memberDao.update(memberdto);
	}
	
	public MemberDto selectOneLogin(MemberDto dto){
		return memberDao.selectOneLogin(dto);
	}
	
	
	
	public MemberDto checkid(MemberDto dto){
		return memberDao.checkid(dto);
	}
	public MemberDto checkclearance(MemberDto dto){
		return memberDao.checkclearance(dto);
	}
	public MemberDto checkem(MemberDto dto){
		return memberDao.checkem(dto);
	}
	public MemberDto checkpw(MemberDto dto){
		return memberDao.checkpw(dto);
	}
	
	
	
	public int uelete(List<Integer>userIds) {
		return memberDao.uelete(userIds);
	}
	
}
