package com.koreait.rest_24_10.boundedContext.member.controller;

import com.koreait.rest_24_10.boundedContext.member.entity.Member;
import com.koreait.rest_24_10.boundedContext.member.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.constraints.NotBlank;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/member", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @Data
    public static class LoginRequest {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }
    @PostMapping("/login")
    public Member login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse resp) {

        resp.addHeader("Authorization", "JWT 토큰");

        return memberService.findByUsername(loginRequest.getUsername()).orElse(null);
    }
}
