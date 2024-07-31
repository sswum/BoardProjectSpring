package org.ssum.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import java.io.IOException;
//로그인 성공 시에 핸들링을 어떻게 할건지
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    //Authentication authentication 권한이 뭐가 들어있는지 , 로그인한 사용자의 인증정보를 가지고 있다.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 세션에 남아 있는 requestLogin 값 제거 ( 성공하게 되면 필요없으니 )
        HttpSession session = request.getSession();
        session.removeAttribute("requestLogin");

        //로그인 이후에 이동할 주소는 다를 수도 있다.
        //로그인 성공 시 - redirectUrl이 있으면 해당 주소로 이동, 아니면 메인 페이지 이동

        String redirectUrl = request.getParameter("redirectUrl");
        redirectUrl= StringUtils.hasText(redirectUrl) ? redirectUrl.trim() : "/";

        //성공하면 해당 주소로 아니면 메인 페이지 주소로 이동하게끔 설정.

        response.sendRedirect(request.getContextPath()+redirectUrl);
    }
}
