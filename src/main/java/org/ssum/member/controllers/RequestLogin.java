package org.ssum.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
//로그인 커맨드 객체
//필수 항목 검증을 할 데이터를 설정 / 이메일과 비밀번호
public class RequestLogin {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private boolean success = true;
    private String code;
    private String defaultMessage;

    private String redirectUrl; // 로그인 성공 시 이동할 주소

}
