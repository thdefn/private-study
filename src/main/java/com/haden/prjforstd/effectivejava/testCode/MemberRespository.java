package com.haden.prjforstd.effectivejava.testCode;

public interface MemberRespository {
    // 인터페이스
    void save(Member member);
    Member findById(Long memberId);
}
