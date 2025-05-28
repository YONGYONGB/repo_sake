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
				.addPathPatterns("/*/*/*Xdm*", "/*/*/*User*")
				.excludePathPatterns(
//						"/resources/**",
						"/user/**",
						"/adt/**",
//						"/xdm/**",
						"/xdm/member/SignupXdmForm",
						"/xdm/member/SigninXdmForm",
						"/xdm/member/SigninXdmProc"
		);
	}

}