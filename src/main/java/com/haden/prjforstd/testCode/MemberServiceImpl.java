package com.haden.prjforstd.testCode;

public class MemberServiceImpl implements MemberService {
    // 구현체가 하나일때는 관례상 인터페이스+임플

    // 구현체로 들어가도 되는군
    private final MemberRespository memberRespository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // 다형성에 의해 인터페이스가 아닌 MemoryMemberRepository에 있는 save가 호출됨
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }

}
