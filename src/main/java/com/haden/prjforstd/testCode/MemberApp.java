package com.haden.prjforstd.testCode;

import com.haden.prjforstd.testCode.Grade;
import com.haden.prjforstd.testCode.Member;
import com.haden.prjforstd.testCode.MemberService;
import com.haden.prjforstd.testCode.MemberServiceImpl;

public class MemberApp {
    //여기서 testCode 패키지 안에 있는 코드들이 잘 돌아가는지 테스트 해보자
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
    // but 메인메서드로 테스트 하는 것은 한계가 있음 jUNIT 사용해보자
}
