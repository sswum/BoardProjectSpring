package org.ssum.member.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.ssum.global.exceptions.ExceptionProcessor;
import org.ssum.member.services.MemberSaveService;
import org.ssum.member.validators.JoinValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@SessionAttributes("requestLogin")
public class MemberController implements ExceptionProcessor {

    private final JoinValidator joinValidator;
    private final MemberSaveService memberSaveService;


    @ModelAttribute
    public RequestLogin requestLogin() {
        return new RequestLogin();
    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {


        return "front/member/join";
        //이번엔 front - pc뷰 ,mobile - 모바일뷰로 분리시킬 것 & admin도 따로
    }

    @PostMapping("/join")               //errors앞에 커맨드객체 꼭 위치 확인!
    public String joinPs(@Valid RequestJoin form, Errors errors) { //기본검증

        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "front/member/join";
        }

        memberSaveService.save(form); //회원 가입 처리


        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute RequestLogin form, Errors errors) {
        String code = form.getCode();
        if (StringUtils.hasText(code)) {
            errors.reject(code, form.getDefaultMessage());
            //비번 만료인 경우 비번 재설정 페이지 이동
            if (code.equals("CredentialsExpired.Login")) {
                return "redirect:/member/password/reset";
            }
        }

        return "front/member/login"; //front
    }

    @ResponseBody
    @GetMapping("/test1")
    @PreAuthorize("isAuthenticated()")
    public void test1() {
        log.info("test1 - 회원만 접근 가능");

    }

    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public void test2() {
        log.info("test2 - 관리자만 접근 가능");
    }


    /**
     * 회원 관련 컨트롤러 공통 처리
     *
     * @param mode
     * @param model
     */
    private void commonProcess(String mode, Model model) {
        mode = Objects.requireNonNullElse(mode, "join");

        List<String> addCss = new ArrayList<>();
        List<String> addCommonScript = new ArrayList<>();
        List<String> addScript = new ArrayList<>();


        addCss.add("member/style");  // 회원 공통 스타일
        if (mode.equals("join")) {
            addCommonScript.add("fileManager");
            addCss.add("member/join");
            addScript.add("member/join");

        } else if (mode.equals("login")) {
            addCss.add("member/login");
        }

        model.addAttribute("addCss", addCss);
        model.addAttribute("addCommonScript", addCommonScript);
        model.addAttribute("addScript", addScript);
    }

    /*
    @ResponseBody
    @GetMapping("/test")
    public void test(Principal principal) {
        log.info("로그인 아이디: {}", principal.getName());
    }

    @ResponseBody
    @GetMapping("/test2")
    public void test2(@AuthenticationPrincipal MemberInfo memberInfo) {
        log.info("로그인 회원 : {}", memberInfo.toString());
    }

    @ResponseBody
    @GetMapping("/test3")
    public void test3() {
        //로그인한 정보 객체 가져오기.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("로그인 상태: {}", authentication.isAuthenticated());
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) {
            // 로그인 상태 - UserDetails 구현체(getPrincipal());
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();
            log.info("로그인 회원: {}", memberInfo.toString());
        } else { // 미로그인 상태 - String / anonymousUser (getPrincipal())
            log.info("getPrincipal(): {}", authentication.getPrincipal());
            // }
        }
    }

    @ResponseBody
    @GetMapping("/test4")
    public void test4() {
        log.info("로그인 여부: {}", memberUtil.isLogin());
        log.info("로그인 회원: {}", memberUtil.getMember());

    }

    @ResponseBody
    @GetMapping("/test5")
    public void test5() {
        /*
                Board board = Board.builder()
                        .bId("freetalk")
                        .bName("자유게시판")
                        .build();

                boardRepository.saveAndFlush(board);
            }

        Board board = boardRepository.findById("freetalk").orElse(null);
        board.setBName("(수정)자유게시판");
        boardRepository.saveAndFlush(board);
    } */

}
