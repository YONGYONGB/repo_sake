package com.sake.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo) {
		return codeDao.selectList(vo);
	}
	
	public int selectOneCount(){
		return codeDao.selectOneCount();
	}
	
	
	public CodeDto selectView(CodeDto codeDto){
		return codeDao.selectView(codeDto);
	}
	
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
}
