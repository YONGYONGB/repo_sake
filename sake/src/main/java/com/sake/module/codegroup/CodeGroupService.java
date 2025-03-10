package com.sake.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList() {
		return codeGroupDao.selectList();
	}
	
	public CodeGroupDto selectView() {
		return codeGroupDao.selectView();
	}
	
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	
}
