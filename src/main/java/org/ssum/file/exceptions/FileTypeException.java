package org.ssum.file.exceptions;

import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class FileTypeException extends CommonException {
    public FileTypeException(HttpStatus status) {
        super("FileType", status);
        setErrorCode(true);
    }
}
