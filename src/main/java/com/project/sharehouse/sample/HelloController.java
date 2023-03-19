package com.project.sharehouse.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        log.info("헬로~~컨트롤러");
        return "성공입니다.";
    }

    @GetMapping("/commons/hello")
    public String hello2() {
        log.info("헬로2~~컨트롤러");
        return "성공입니다.";
    }

}
