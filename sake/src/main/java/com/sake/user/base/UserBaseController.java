package com.sake.user.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sake.module.product.ProductUserService;

@Controller
public class UserBaseController {

	
	@Autowired
	ProductUserService puservice;
	
	@RequestMapping(value = "/user/index/UserIndex")
	public String home(Model model) {
		int count = puservice.sakeCount();
		String[] seqList = new String[30];
//		String count = String.valueOf(puservice.sakeCount());
		for(int i=0; i<30; i++) {
			seqList[i] = String.valueOf((int)(Math.random() * count) + 1);
		}
		model.addAttribute("items", puservice.randomList(seqList));
		return "/user/index/UserIndex";
	}
	
	//암호화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	//암호 확인
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	
}
