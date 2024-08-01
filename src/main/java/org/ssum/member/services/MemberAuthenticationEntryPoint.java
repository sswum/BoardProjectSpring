package org.ssum.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.StringUtils;

import java.io.IOException;

//인증 인가 실패 시 유입되는 경로 지정
public class MemberAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        /**
         * 회원 전용 페이지로 접근한 경우 - /mypage -> 로그인 페이지 이동
         * 관리자 페이지로 접근한 경우 - 응답 코드 401 에러페이지 출력
         */

        String uri = request.getRequestURI();
        if (uri.contains("/admin")) { //관리자 페이지
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED); //관리자가 아닐 경우 401 에러코드
        } else { //회원 페이지
            String qs = request.getQueryString();
            String redirectUrl = uri.replace(request.getContextPath(), "");
            if (StringUtils.hasText(qs)) {
                redirectUrl += "?" + qs;
            }
            response.sendRedirect(request.getContextPath()+"/member/login?redirectUrl="+redirectUrl); // 회원이면 로그인 페이지로
        }

    }
}

