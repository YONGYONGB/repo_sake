package com.sake.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sake.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {       //WebMvcConfigurerImpl 클래스에서 하는 일(인터셉터 등록)은 스프링 MVC 레벨의 요청 전처리를 위한 것
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//				.order(1)
				.addPathPatterns("/*/*/*Xdm*","/user/account/**","/user/cart/**","/user/order/**")  // 이패턴들은 다 금지.
//				.addPathPatterns("/*/*/*Xdm*")  // 이패턴들은 다 금지.
				.excludePathPatterns(
//						"/resources/**",
//						"/static/**",
						"/user/template/**",
						"/user/product/**",
//						"/adt/**",
//						"/xdm/**",
						"/xdm/member/SignupXdmForm",
						"/xdm/member/SigninXdmForm",
						"/xdm/member/SigninXdmProc"
		);
	}

}