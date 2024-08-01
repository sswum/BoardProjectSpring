package org.ssum.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.ssum.member.controllers.RequestLogin;

import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException { //로그인 실패시에 유입되는 메서드


        HttpSession session = request.getSession();

        //요청 데이터 담기
        RequestLogin form = new RequestLogin();

        form.setEmail(request.getParameter("email"));
        form.setPassword(request.getParameter("password"));

        if (exception instanceof BadCredentialsException) {
            //아이디 또는 비밀번호가 일치하지 않는 경우
            form.setCode("BadCredentials.Login");
        } else if (exception instanceof DisabledException) {
            //탈퇴한 회원
            form.setCode("Disabled.Login");
        } else if (exception instanceof CredentialsExpiredException) {
            //비밀번호 유효기간 만료
            form.setCode("CredentialsExpired.Login");
        } else if (exception instanceof AccountExpiredException) {
            //사용자 계정 유효기간 만료
            form.setCode("AccountExpired.Login");
        } else if (exception instanceof LockedException) {
            //사용자 계정이 잠겨 있는 경우 발생
            form.setCode("LockedException.Login");
        } else {
            form.setCode("Fail.Login");
        }
        form.setDefaultMessage(exception.getMessage());
        //위에것에 해당이 안될 경우 기본 메세지가 나올 수 있게끔 설정


        System.out.println(exception);

        form.setSuccess(false);
        session.setAttribute("requestLogin", form);

        //로그인 실패 시 로그인 페이지 이동
        response.sendRedirect(request.getContextPath() + "/member/login");

    }
}
