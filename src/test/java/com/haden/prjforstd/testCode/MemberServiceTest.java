package com.haden.prjforstd.testCode;

import com.haden.prjforstd.effectivejava.testCode.Grade;
import com.haden.prjforstd.effectivejava.testCode.Member;
import com.haden.prjforstd.effectivejava.testCode.MemberService;
import com.haden.prjforstd.effectivejava.testCode.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    // 나중에 빌드해서 나가면 메인에 대한 코드 안나고 테스트 코드는 운영 환경에 배포 안됨
    // 동일한 위치에 패키지 만들어주기

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given 이런이런게 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이렇게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
        // member는 findMember랑 똑같니 ?
    }
}
