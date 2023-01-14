package com.haden.prjforstd.effectivejava.testCode;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRespository {
    //인터페이스에 대한 구현체
    //아직 데이터베이스가 기획상 확정이 안되었기 때문에 메모리 멤버 레파지토리로 만든 상황이라고 가정 : 테스트용이기는 하나

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
