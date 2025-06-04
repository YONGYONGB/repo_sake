//package com.sake.common.config;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration // 메모리에 떠야해서
//@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨. 활성화
// // secured 어노테이션 활성화, preAuthorize 어노테이션 활성화 -> 특정부분에 넣고싶을때
//public class SecurityConfig {
//	
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            // ✅ CSRF(Cross Site Request Forgery) 보호 비활성화
//	            // - 기본적으로 POST 요청 등에 대해 CSRF 토큰이 없으면 거부됨
//	            // - API 개발, 테스트, 혹은 일반 웹사이트에서 로그인 테스트 시에는 꺼주는 경우가 많음
//	            .csrf(csrf -> csrf.disable())
//
//	         // ✅ URL 별 권한/인증 설정
//	            .authorizeHttpRequests(auth -> auth
//	                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//	                    .requestMatchers("/user/sign/SigninUserProc","/user/sign/signin", "/user/index/UserIndex", "/user/template/**", "/xdm/**", "/user/product/sakeMenu").permitAll()
//	                    .anyRequest().permitAll()
//	                )
//
//	            // ✅ 폼 로그인 설정
//	            .formLogin(form -> form
//	                // 사용자 정의 로그인 페이지 경로
//	                // - 사용자가 직접 만든 로그인 화면 (/signin)으로 이동
//	                .loginPage("/user/sign/signin")
//	                // 로그인 요청이 처리되는 경로
//	                // - 이 경로로 요청이 오면 스프링 시큐리티가 자동으로 로그인 처리를 수행
//	                // - 컨트롤러를 따로 만들 필요 없음
//	                .loginProcessingUrl("/user/sign/signin")
//	                // 로그인 성공 시 리다이렉트할 기본 경로
//	                // - true: 항상 지정된 경로("/")로 이동
//	                // - false일 경우, 사용자가 로그인 요청 전 머물렀던 페이지로 이동
//	                .usernameParameter("id")  // 만약 로그인 폼에서 아이디 input name이 userId라면
//	                .passwordParameter("password")
//	                .defaultSuccessUrl("/", true)
//	                .permitAll() 
//	                // (옵션) 로그인 실패 시 이동 경로도 설정 가능
//	                // .failureUrl("/signin?error=true")
//	            );
//
//	        // http.build()를 통해 설정 완료 후 필터체인 반환
//	        return http.build();
//	    }
//    
//	    @Bean
//	    public WebSecurityCustomizer webSecurityCustomizer() {
//	        return (web) -> web.ignoring()
//	                           .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//	    }
//    
//    @Bean 
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}