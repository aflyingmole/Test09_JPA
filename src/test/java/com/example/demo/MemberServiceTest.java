package com.example.demo;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MemberServiceTest {
    @Autowired
    private MemberService service;

    @Test
    void save() {
        service.join(new MemberDto("hello2", "1234", "hello@", 10, null));
        service.join(new MemberDto("hell2", "2345", "helo@", 20, null));
    }

    @Test
    void list() {
        List<MemberDto> list = service.list();
        for (MemberDto m : list) {
            System.out.println(m);
        }
    }

    @Test
    void delete() {
        service.delete("hello");
    }



    @Test
    void update() {
        MemberDto updatedDto = new MemberDto("hell2", "newPass123", "newEmail@example.com", 30, null);
        MemberDto updatedMember = service.update(updatedDto);
        System.out.println(updatedMember);
    }
}
