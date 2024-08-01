package org.ssum.global.exceptions.script;

import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class AlertException extends CommonException {
    public AlertException(String message, HttpStatus status) {
        super(message, status);  //자바스크립 형태로 에러 알림창
    }
}
