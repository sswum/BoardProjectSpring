package org.ssum.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssum.global.exceptions.ExceptionProcessor;

import java.util.List;

@RequestMapping("/")
@Controller
public class MainController implements ExceptionProcessor {

    @GetMapping
    public String index(Model model) //request를 안 쓰고 model을 쓰는 이유는 다른 기능이 연계 돼있어서

    {
        model.addAttribute("addCommonScript", List.of("fileManager"));
        model.addAttribute("addScript", List.of("test/form"));
        return "front/main/index"; // 템플릿 경로
    }
}
