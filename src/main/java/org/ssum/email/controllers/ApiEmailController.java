package org.ssum.email.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssum.email.service.EmailVerifyService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/email")
public class ApiEmailController {
    private final EmailVerifyService verifyService;

    /**
     * 이메일 인증 코드 발급
     */

    //public JSONData<Object> sendVerifyEmail(@RequestParam("email") String email) {
      //  JSonData
   // }


}
