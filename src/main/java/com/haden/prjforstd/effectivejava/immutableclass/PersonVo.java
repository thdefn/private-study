package com.haden.prjforstd.effectivejava.immutableclass;

import com.haden.prjforstd.effectivejava.comparable.Person;
import lombok.Getter;

@Getter
public class PersonVo {
    // immutable한 VO를 만드는 실제 케이스
    // get만 있고 set이 없음 생성자는 private
    // 값이 변하지 않는 객체라면 다음과 같이 불변성을 강제하는 것 또한 방법이다
    private final String name;
    private final double height;

    private PersonVo(String name, double height) {
        this.name = name;
        this.height = height;
    }
    // from이라는 팩토리메서드를 통해 PersonVo를 만드록 더 이상 변경할 수 없게

    public static final PersonVo from(Person p){
        return new PersonVo(p.getName(), p.getHeight());
    }
}
