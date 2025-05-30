package com.sake.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckLoginSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		관리자용
		if(request.getRequestURI().contains("xdm")) {
			if (request.getSession().getAttribute("sessNameXdm") != null) {
				
				// by pass
			} else {
				response.sendRedirect("/xdm/member/SigninXdmForm");
				
		        return false;
			}
		} else {
//			by pass
		}
		
////		사용자용
		if(request.getRequestURI().contains("user")) {
			if (request.getSession().getAttribute("sessSeqUser") != null) {
				// by pass
			} else {
				response.sendRedirect("/user/sign/signin");
				return false;
			}
		} else {
//			by pass
		}
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}