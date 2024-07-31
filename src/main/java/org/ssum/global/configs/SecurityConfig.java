package org.ssum.global.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.ssum.member.services.LoginFailureHandler;
import org.ssum.member.services.LoginSuccessHandler;

@Configuration
public class SecurityConfig {//개발된 이유가 인증,인가 => 접근 통제와 관련 =>해시화 시키기 위해

    @Bean //이건 정형화된 설정이니까 따라 쓰면 된다.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /* 로그인 , 로그아웃 S */

        http.formLogin(f -> { //기본적인 정보를 넘겨 줘야지 확인할 수 있기 때문에 파라미터로 값을 넘겨줌
            f.loginPage("/member/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .successHandler(new LoginSuccessHandler()) //successForwardUrl은 성공 시 이동할 페이지 지정
                    .failureHandler(new LoginFailureHandler());
        });

        http.logout(f -> {
            f.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                    .logoutSuccessUrl("/member/login");
        });


        /* 로그인 , 로그아웃 E */

        /* 인가(접근 통제) 설정 S */

        http.authorizeHttpRequests(c -> {
            c.requestMatchers("/mypage/**")
        });

        /* 인가(접근 통제) 설정 E */


        return http.build(); //이걸 설정하고 나면 로그인페이지가 나오지 않는다.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //해시화
    }
}
