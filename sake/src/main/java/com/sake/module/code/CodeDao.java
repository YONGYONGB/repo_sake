package com.sake.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {

	public List<CodeDto> selectList(CodeVo vo);
	
	public int selectOneCount();
	
	public CodeDto selectView(CodeDto codeDto);
	
	public int insert(CodeDto codeDto);
	
	
}
