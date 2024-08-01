package org.ssum.global.validators;

public interface PasswordValidator {

    /**
     * 알파벳 복잡성 체크
     *
     * @param password
     * @param caseInsensitive - false : 대소문자 각각 1개씩 이상 포함, true - 대소문자 구분 X
     * @return
     */
    default boolean alphaCheck(String password, boolean caseInsensitive) {
        if (caseInsensitive) { //대소문자 구분없이 알파벳 체크
            return password.matches(".*[a-zA-Z]+.*"); //.* .*  =>처음부터 체크하려는 표현식
            // + => 한 개이상 체크를 해랏~
        }
        return password.matches(".*[a-z]+.*") && password.matches(".*[A-Z].*");
    }
    /** 숫자 복잡성 체크
     *
     * @param password
     * @return
     */

    default boolean numberCheck(String password) {
        return password.matches(".*\\d+.*"); // .* .*  => 중요! 중간에 포함된 숫자를 확인해야 하기 때문에
        //숫자가 1개이상 포함 돼있는지를 체크
    }
    /**
     *  특수문자 복잡성 체크
     * @param password
     * @return
     */
    default boolean specialCharsCheck(String password) {
        String pattern= ".*[^0-9a-zA-Zㄱ-ㅎ가-힣]+.*";
        //정규표현식에서 꺽새는 __ 가 아닌 것을 표현
        return password.matches(pattern);
    }

}
