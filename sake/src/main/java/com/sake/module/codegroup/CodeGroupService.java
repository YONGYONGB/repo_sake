package com.sake.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	

	public int selectOneCount() {
		return codeGroupDao.selectOneCount();
	}
	
	
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo) {
		return codeGroupDao.selectList(vo);
	}
	
	public CodeGroupDto selectView(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectView(codeGroupDto);
	}
	
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	
	
}
