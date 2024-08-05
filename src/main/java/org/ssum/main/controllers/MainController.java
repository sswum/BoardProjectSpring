package org.ssum.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssum.global.exceptions.ExceptionProcessor;

@RequestMapping("/")
@Controller
public class MainController implements ExceptionProcessor {

    @GetMapping
    public String index() {
        return "front/main/index"; // 템플릿 경로
    }
}
