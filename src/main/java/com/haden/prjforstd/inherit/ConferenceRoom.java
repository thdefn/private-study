package com.haden.prjforstd.inherit;

import java.util.List;

class ConferenceRoom implements Contact{
    // composite
    // 일종의 composite class : person과 ShareNote를 리스트로 관리하는 composite, 회의실

    // 각각의 contact를 리스트로 가지고 있음
    // 화면 공유는 한명만
    private List<Contact> contacts;

    @Override
    public void join() {
        // contacts를 조인 시킨다
    }
}