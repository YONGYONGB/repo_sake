package com.sake.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {


	public List<CodeGroupDto> selectList();
	
	public CodeGroupDto selectView();
	
	public int insert(CodeGroupDto codeGroupDto);
	
	public int delete(CodeGroupDto codeGroupDto);
}
