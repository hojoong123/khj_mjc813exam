package com.mjc813.webcrud.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/member/")
    public String member() {
        return "/member/index";
    }

    @GetMapping("/member/add")
    public String memberAdd() {
        return "/member/add";
    }

    @PostMapping("/member/insert")
    public String memberInsert(@ModelAttribute MemberDto obj) {

        return "";
    }

    @GetMapping("/member/list")
    public String list(Model model) {
        List<MemberDto> arraylist = this.memberRepository.findAll();
        model.addAttribute("list", arraylist);
        return "/member/members";
    }
}
