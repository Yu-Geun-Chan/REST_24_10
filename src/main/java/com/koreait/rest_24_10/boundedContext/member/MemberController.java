package com.koreait.rest_24_10.boundedContext.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 모든 메서드들에 @ResponseBody를 포함시키고 싶을 때
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/login")
    public String login() {
        return "성공";
    }
}
