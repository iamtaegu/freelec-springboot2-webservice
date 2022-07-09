package jpabook.jpashop.controller;

import jpabook.jpashop.service.LogTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final LogTableService logTableService;

    @GetMapping("/log/insert")
    public String logInsert() {
        logTableService.logInsert();

        return "OK";
    }
}
