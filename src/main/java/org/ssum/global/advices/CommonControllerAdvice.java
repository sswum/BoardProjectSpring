package org.ssum.global.advices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.ssum.global.entities.Member;
import org.ssum.member.MemberUtil;

@RequiredArgsConstructor
@ControllerAdvice("org.ssum")
public class CommonControllerAdvice {

    private final MemberUtil memberUtil;

    @ModelAttribute("loggedMember")
    public Member loggedMember() {
        return memberUtil.getMember();
    }

    @ModelAttribute("isLogin")
    public boolean isLogin() {
        return memberUtil.isLogin();
    }

    @ModelAttribute("isAdmin")
    public boolean isAdmin() {
        return memberUtil.isAdmin();
    }
}
