package com.mjc813.webcrud.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String userid;
    private String passwd;
    private String name;
    private String nickName;
}
