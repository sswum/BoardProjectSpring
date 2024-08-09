package org.ssum.global.advices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.ssum.file.entities.FileInfo;
import org.ssum.member.MemberUtil;
import org.ssum.member.entities.Member;

@RequiredArgsConstructor
@ControllerAdvice("org.ssum") //범위 설정
public class CommonControllerAdvice { //전역에서 확인 가능

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

    @ModelAttribute("myProfileImage")
    public FileInfo myProfileImage() {
        if (isLogin()) {
            Member member = memberUtil.getMember();
            return member.getProfileImage();
        }

        return null;
    }
}
