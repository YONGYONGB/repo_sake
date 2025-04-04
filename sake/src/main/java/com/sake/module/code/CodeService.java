package com.sake.module.code;

import java.text.Normalizer;
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
		
		return codeDao.selectList(vo);
	}
	
	public CodeDto selectView(CodeDto codeDto){
		return codeDao.selectView(codeDto);
	}
	
	public int selectOneCount(CodeVo vo){
		return codeDao.selectOneCount(vo);
	}
	
	
	public List<CodeDto> selectCg(CodeDto codeDto){
		return codeDao.selectCg(codeDto);
	}
	
	public int insert(CodeDto codeDto) {
		 if (codeDto.getCd_name() != null) {
	            // 유니코드 정규화 (NFC 형태로)
	            String normalizedName = Normalizer.normalize(codeDto.getCd_name(), Normalizer.Form.NFC);
	            codeDto.setCd_name(normalizedName);
	        }
		return codeDao.insert(codeDto);
	}
	
	public int update(CodeDto codeDto) {
		 if (codeDto.getCd_name() != null) {
	            String normalizedName = Normalizer.normalize(codeDto.getCd_name(), Normalizer.Form.NFC);
	            codeDto.setCd_name(normalizedName);
	        }
		return codeDao.update(codeDto);
	}
	
	public int uelete(List<Integer> cgIds) {
		return codeDao.uelete(cgIds);
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
	
	
	public static List<CodeDto> selectListCachedCode(String cg_id) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeGroup_cg_id().equals(cg_id)) {
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
