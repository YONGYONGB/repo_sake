package com.sake.user.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sake.module.member.MemberDao;
import com.sake.module.member.MemberDto;

@Service
public class AccountCodeService {
	@Autowired
	AccountCodeDao dao;
	
	@Autowired
	MemberDao memberDao;
	////////
	// 계정등록
	///////
	public MemberDto accountSetting(String num){
		return memberDao.accountSetting(num);
	}
	
	public int accountUpdate(MemberDto memberdto) {
		return memberDao.accountUpdate(memberdto);
	}
	
	public int changepw(MemberDto dto){
		return memberDao.changepw(dto);
	}
	
	public int withdrawAction(String user_id) {
		return memberDao.withdrawAction(user_id);
	}
	
	///////
	// 주소
	///////
	public List<AccountCodeDto> addressList(AccountCodeDto dto){
		return dao.addressList(dto);
	}

	public int addressInsert(AccountCodeDto dto){
		return dao.addressInsert(dto);
	}
	public int addressDelete(AccountCodeDto dto){
		return dao.addressDelete(dto);
	}
	
	public void updateRepresentive(String ua_id, String seq) {
		dao.resetrep(seq);
		dao.setrep(seq,ua_id);
	}
	
}
