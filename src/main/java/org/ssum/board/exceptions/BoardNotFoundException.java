package org.ssum.board.exceptions;


import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class BoardNotFoundException extends CommonException {
    public BoardNotFoundException() {
        super("NotFound.board", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}
