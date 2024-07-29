package org.ssum.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestJoin {
   @Email
   @NotBlank // 필수항목 체크
    private String email;

    @NotBlank @Size(min=8) //8자리 이상
    private String password;
    @NotBlank
    private String userName;
    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String mobile;

    @AssertTrue
    private boolean agree;

}
