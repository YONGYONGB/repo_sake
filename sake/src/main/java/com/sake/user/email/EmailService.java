package com.sake.user.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sake.module.member.MemberDto;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	
	public void sendMailWelcome(MemberDto memberDto , TemplateVo templateVo) throws Exception{
		
		String contentsHtml = "<h1>환영합니다, " + memberDto.getName() + "님!</h1>"
                + "<p>이메일: " + memberDto.getEmail() + "</p>";
    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(memberDto.getEmail()); 
    	mimeMessageHelper.setSubject("회원가입메일");
    	mimeMessageHelper.setText(contentsHtml, true); 
    	javaMailSender.send(mimeMessage);
    	
    }
}
