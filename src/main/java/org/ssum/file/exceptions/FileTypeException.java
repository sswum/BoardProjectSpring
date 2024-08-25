package org.ssum.file.exceptions;

import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class FileTypeException extends CommonException {
    //파일타입이 다른 경우 제외
    public FileTypeException(HttpStatus status) {
        super("FileType", status);
        setErrorCode(true);
    }

}
