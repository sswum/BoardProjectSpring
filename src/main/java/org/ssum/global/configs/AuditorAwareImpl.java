package org.ssum.global.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.ssum.member.MemberUtil;

import java.util.Optional;

@RequiredArgsConstructor
@Component

public class AuditorAwareImpl implements AuditorAware<String> {
    private final MemberUtil memberUtil;

    @Override
    public Optional<String> getCurrentAuditor() {
        String email= memberUtil.isLogin() ? memberUtil.getMember().getEmail() : null;

        return Optional.ofNullable(email);
    }
}
