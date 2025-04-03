package com.sake.user.sign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sake.module.member.MemberDao;
import com.sake.module.member.MemberDto;
@Service
public class SignCodeService {
	@Autowired
	MemberDao memberdao;
	
	public int insert(MemberDto memberdto){
		return memberdao.insert(memberdto);
	}
}
