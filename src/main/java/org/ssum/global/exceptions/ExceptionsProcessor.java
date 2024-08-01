package org.ssum.global.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.ssum.global.exceptions.script.AlertException;

public interface ExceptionsProcessor {
    @ExceptionHandler(Exception.class)
    default ModelAndView errorHandler(Exception e, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 기본 응답 코드 500
        String tpl = "error/error";
        if (e instanceof CommonException commonException) {
            status = commonException.getStatus();
        }

        if (e instanceof AlertException) {
            //원래 에러페이지가 String tpl = "error/error"; 여기지만 자바스크립형태 일 경우 밑에꺼가 나오게
            tpl = "common/_execute_script";
            String script = String.format("alert('%s');", e.getMessage());
        }


        String url = request.getRequestURI();
        String qs = request.getQueryString();


        if (StringUtils.hasText(qs)) url += "?" + qs;


        mv.addObject("message", e.getMessage());
        mv.addObject("status", status.value());
        mv.addObject("method", request.getMethod());
        mv.addObject("path", url);
        mv.setStatus(status);
        mv.setViewName(tpl);

        return mv;
    }
}
