package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")  // '/' → '/home'으로 변경
    public String home() {
        return "home";
    }
}
