package org.ssum.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join() {
        return "front/member/join"; //이번엔 pc와 모바일을 분리시킬 것
    }

    @PostMapping("/join")
    public String joinPs() {

        return "redirect:/member/login";//회원 가입 끝나면 로그인 페이지로 이동하겠당
    }
    @GetMapping("/login")
    public String login() {

        return "front/member/login"; //front
    }
}

