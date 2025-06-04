package com.sake.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
//implements UserDetailsService{

	@Autowired
	MemberDao memberDao;
	
	
//	 @Override
//	    public UserDetails loadUserByUsername(String username) {
//	    		throws UsernameNotFoundException {
//	        MemberDto member = memberDao.findByUsername(username); // 또는 selectOneLogin 등 적절한 메서드 호출
//
//	        if (member == null) {
//	            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
//	        }
//	        return new PrincipalDetails(member);
//	    }
	
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
