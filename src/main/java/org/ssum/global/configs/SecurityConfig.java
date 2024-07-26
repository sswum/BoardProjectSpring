package org.ssum.global.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {//개발된 이유가 인증,인가 => 접근 통제와 관련 =>해시화 시키기 위해 빅큐리티? 넣으면됨

    @Bean //이건 정형화된 설정이니까 따라 쓰면 된다.
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.build(); //이걸 설정하고 나면 로그인페이지가 나오지 않는다.
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //해시화
    }
}
