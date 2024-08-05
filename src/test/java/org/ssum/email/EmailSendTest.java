package org.ssum.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.ssum.email.service.EmailMessage;
import org.ssum.email.service.EmailSendService;
import org.ssum.email.service.EmailVerifyService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class EmailSendTest {

    @Autowired
    private EmailSendService emailSendService;
    @Autowired
    private EmailVerifyService emailVerifyService;

    @Test
    void sendTest() {
        EmailMessage message = new EmailMessage("l5450won@naver.com","이메일 전송 연습증","제대로 왔나요?");
        boolean success= emailSendService.sendMail(message);

        assertTrue(success);
    }
    @Test
    @DisplayName("템플릿 형태로 전송 테스트")
    void sendWithTplTest() {
        EmailMessage message = new EmailMessage("l5450won@naver.com", "제목", "내용...");
        Map<String, Object> tplData = new HashMap<>();
        tplData.put("authNum", "123456789");
        boolean success = emailSendService.sendMail(message, "auth", tplData);
        assertTrue(success);

    }
    @Test
    @DisplayName("이메일 인증 번호 전송 테스트")
void setEmailVerifyService() {
        boolean result = emailVerifyService.sendCode("l5450won@naver.com");
        assertTrue(result);
    }
}
