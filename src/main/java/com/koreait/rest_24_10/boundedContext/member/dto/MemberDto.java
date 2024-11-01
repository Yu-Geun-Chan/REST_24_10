package com.koreait.rest_24_10.boundedContext.member.dto;

import com.koreait.rest_24_10.boundedContext.member.entity.Member;

import java.time.LocalDateTime;

public class MemberDto {
    private Long id;
    private LocalDateTime regDate;
    private String userName;

    private MemberDto(Member member) {
        this.id = member.getId();
        this.userName = member.getUsername();
        this.regDate = member.getCreateDate();
    }
    public static MemberDto of(Member member) {
        return new MemberDto(member);
    }
}
