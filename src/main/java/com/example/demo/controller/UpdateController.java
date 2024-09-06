package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UpdateController {
    @Autowired
    MemberService service;
    @GetMapping("/member/update")
    public String updateForm(@RequestParam("id")String id, Model model) {
        MemberDto dto = service.select(id);
        model.addAttribute("dto", dto);
        return "member/update";
    }
    @PostMapping("/member/update")
    public String update(MemberDto dto, Model model) {
        MemberDto update = service.update(dto);
        model.addAttribute("update", "회원정보 수정완료");
        return "home";
    }

}
