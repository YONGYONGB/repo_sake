package com.sake.user.accountcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCodeDao {

	
	public int insert(AccountCodeDto accountCodeDto);
	
}
