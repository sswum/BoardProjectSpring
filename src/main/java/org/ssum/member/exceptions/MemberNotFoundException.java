package org.ssum.member.exceptions;

import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class MemberNotFoundException extends CommonException {
    public MemberNotFoundException() {
        super("NotFound.member", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}

