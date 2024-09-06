package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    @Autowired
    MemberService service;
    @GetMapping("/member/join")
    public String joinForm() {
        return "member/join";
    }
    @PostMapping("/member/join")
    public String join(MemberDto dto, Model model) {
        MemberDto join = service.join(dto);
        if (join == null) {
            model.addAttribute("join", "회원가입에 실패했습니다ㅠㅠ");
        } else {
            model.addAttribute("join", "회원가입에 성공했습니다!!!!");
        }
        return "member/result";
    }

}
