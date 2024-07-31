package org.ssum.global.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.ssum.member.MemberUtil;

import java.util.Optional;

@RequiredArgsConstructor
@Component
//자동로그인한 회원은 자동으로 값이 들어가게끔 <String> => email값을 넣을거라
public class AuditorAwareImpl implements AuditorAware<String> {
    private final MemberUtil memberUtil;

    @Override
    public Optional<String> getCurrentAuditor() { //삼항조건식으로 이메일 찾기
        String email= memberUtil.isLogin() ? memberUtil.getMember().getEmail() : null;

        return Optional.ofNullable(email); // ofNullable을 사용해야 한다
    }
}
