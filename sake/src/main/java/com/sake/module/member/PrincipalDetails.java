//package com.sake.module.member;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class PrincipalDetails implements UserDetails {
//
//    private MemberDto member;
//
//    public PrincipalDetails(MemberDto member) {
//        this.member = member;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // 권한 컬럼이 없으니 기본 ROLE_USER 하나만 부여
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(() -> "ROLE_USER");  // 하드코딩된 기본 권한
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return member.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return member.getName();
//    }
//
//    // 나머지 메서드도 적절히 구현 (계정 활성화 여부 등)
//}
