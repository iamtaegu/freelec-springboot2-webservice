package jpabook.jpashop.controller;

import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SpringDataJPAController {

    private final MemberService memberService;

    @GetMapping("/springDataJPA/Query")
    public String query(@RequestParam String email, @RequestParam String name) {
        log.debug("[SpringDataJPAController] email={}", email);
        log.debug("[SpringDataJPAController] name={}", name);
        return memberService.findEmailOrName(email, name);
    }

    @GetMapping("/springDataJPA/pagingAndSort")
    public String pagingAndSort(@RequestParam String name) {
        return memberService.findByNameStartingWith(name);
    }

}
