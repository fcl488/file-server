package com.fcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String toIndex() {
        return "index";
    }

    @GetMapping("/toAddCard")
    public String toAddCard() {
        return "addCard";
    }
}
