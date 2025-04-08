package com.sake.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sake.module.member.MemberDao;
import com.sake.module.member.MemberDto;

@Service
public class AccountCodeService {
	@Autowired
	MemberDao memberDao;

	public MemberDto accountSetting(String num){
		return memberDao.accountSetting(num);
	}
	
	public int accountUpdate(MemberDto memberdto) {
		return memberDao.accountUpdate(memberdto);
	}
	
	public int changepw(MemberDto dto){
		return memberDao.changepw(dto);
	}
}
