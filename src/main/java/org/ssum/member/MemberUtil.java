package org.ssum.member;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.ssum.global.entities.Member;
import org.ssum.member.constants.Authority;
import org.ssum.member.entities.Authorities;

import java.util.List;

@Component
public class MemberUtil { //회원 정보를 가공해서 편의 기능 만들기

    public boolean isLogin() {
        return getMember() != null;
    }

    public boolean isAdmin() {
        if (isLogin()) {
            Member member = getMember();
            List<Authorities> authorities = member.getAuthorities();
            return authorities.stream().anyMatch(s -> s.getAuthority() == Authority.ADMIN);
        }

        return false;
    }

    public Member getMember() { //로그인 한 후 회원정보를 가지고 서비스 가공
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) {
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();
            return memberInfo.getMember();
        }
        return null;
    }
}
