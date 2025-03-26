package com.sake.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {

	public List<CodeDto> selectList(CodeVo vo);
	
	public int selectOneCount(CodeVo vo);
	
	public List<CodeDto> selectCg(CodeDto codeDto);
	
	public int insert(CodeDto codeDto);
	
	
	public List<CodeDto> selectListCachedCodeArrayList();
	
	public CodeDto selectView(CodeDto codeDto);
	
	
	public int update(CodeDto codeDto);
}
