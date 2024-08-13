package org.ssum.board.exceptions;

import org.springframework.http.HttpStatus;
import org.ssum.global.exceptions.CommonException;

public class BoardDataNotFoundException extends CommonException {

    public BoardDataNotFoundException() {
        super("NotFound.boardData", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}
