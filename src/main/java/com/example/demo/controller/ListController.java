package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private MemberService service;
    @GetMapping("/member/list")
    public String list(Model model) {
        List<MemberDto> list = service.list();
        model.addAttribute("list", list);
        return "member/list";

    }
}
