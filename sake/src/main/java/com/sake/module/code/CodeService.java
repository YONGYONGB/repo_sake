package com.sake.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {

	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo) {		
		
//	list이기에 반복문을 쓸수있다.
		
		return codeDao.selectList(vo);
	}
	
	public int selectOneCount(){
		return codeDao.selectOneCount();
	}
	
	
	public List<CodeDto> selectCg(CodeDto codeDto){
		return codeDao.selectCg(codeDto);
	}
	
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	
	
	
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
   
    
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String codeGroup_cg_id) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeGroup_cg_id().equals(codeGroup_cg_id)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
	

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCd_id().equals(Integer.toString(code))) {
				rt = codeRow.getCd_name();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	
	
	
}
