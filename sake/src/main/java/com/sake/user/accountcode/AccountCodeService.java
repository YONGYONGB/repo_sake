package com.sake.user.accountcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCodeService {

	
	@Autowired
	AccountCodeDao accountCodeDao;
	
	public int insert(AccountCodeDto accountCodeDto){
		return accountCodeDao.insert(accountCodeDto);
	}
}
