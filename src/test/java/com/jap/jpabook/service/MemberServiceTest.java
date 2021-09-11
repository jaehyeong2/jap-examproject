package com.jap.jpabook.service;

import com.jap.jpabook.domain.Member;
import com.jap.jpabook.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("kin");

        //when
        Long saveId = memberService.join(member);

        //then


    }

    @Test
    public void duplicateExcep() throws Exception{

    }

}