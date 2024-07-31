package org.ssum.global.validators;

public interface MobileValidator {
    default boolean mobileCheck(String mobile) {
        /**
         * 01[016]-0000/000-0000
         * 01[016]-\d{3,4}-\d{4}
         * 010. 1111 .1111
         * 010 1111 1111
         * 010-1111-1111
         * 01011111111
         * 1. 숫자만 남긴다. 2. 패턴 만들기 3. 체크
         * 예) 0101111111111111111111111111111
         */
        mobile = mobile.replaceAll("\\D", "");
        String pattern = "01[016]\\d{3,4}\\d{4}$";  //=> 처음 시작부터라 01로 쓴 거고 { } 중괄호 안에
        //제한하는 글자수를 제한, 중간은 3~4글자만 , 마지막은 4글자로 끝나도록

        return mobile.matches(pattern);

    }
}
