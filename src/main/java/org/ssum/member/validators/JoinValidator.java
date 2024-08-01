package org.ssum.member.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.ssum.global.validators.MobileValidator;
import org.ssum.global.validators.PasswordValidator;
import org.ssum.member.controllers.RequestJoin;
import org.ssum.member.repositories.MemberRepository;

@RequiredArgsConstructor
@Component
public class JoinValidator implements Validator, PasswordValidator, MobileValidator {

    private final MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);

    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        /**
         *  1. 이미 가입된 회원인지 체크
         *  2. 비밀번호, 비밀번호 확인 일치 여부
         *  3. 비밀번호 복잡성 체크
         *  4. 휴대전화번호 형식 체크
         */

        RequestJoin form = (RequestJoin) target;
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String mobile = form.getMobile();

        // 1. 이미 가입된 회원인지 체크
        if (memberRepository.exists(email)) {
            errors.rejectValue("email", "Duplicated");
        }

        // 2. 비밀번호, 비밀번호 확인 일치 여부
        if (!password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Mismatch.password");
            //에러가 나면 리젝트값으로 필드명이 컨펌패스워드인 걸 찾고 에러코드 메세지:" " 내용이 나올거다
        }
        // 3. 비밀번호 복잡성 체크 - 알파벳 대소문자 각각 1개 이상 , 숫자 1개 이상, 특수문자 1개 이상
        if (!alphaCheck(password, false) || !numberCheck(password) ||
                !specialCharsCheck(password)) {
            errors.rejectValue("password", "Complexity");
        }

        // 4. 휴대전화번호 형식 체크
        if (!mobileCheck(mobile)) {
            errors.rejectValue("mobile", "Mobile");
        }
    }
}
