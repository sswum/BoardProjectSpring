package org.ssum.tour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssum.global.exceptions.ExceptionProcessor;

import java.util.List;

@Controller
@RequestMapping("/tour")
public class TourController implements ExceptionProcessor {
    //여행 소개 페이지

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long seq, Model model) {

        model.addAttribute("addCommonScript", List.of("map"));
        model.addAttribute("addScript", List.of("tour/view"));

        return "front/tour/view";
    }

}
