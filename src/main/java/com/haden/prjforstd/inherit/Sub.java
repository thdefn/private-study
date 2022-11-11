package com.haden.prjforstd.inherit;

import java.io.Serializable;
import java.time.Instant;

public class Sub extends Super implements Serializable, Cloneable {
    // Sub이라는 클래스는 Super을 확장해서 사용하고 Serializable이나 Clonealbe을 구현한다
    private final Instant instant;

    public Sub() {
        instant = Instant.now(); // Sub 생성시 instant에 Instant.now()를 넣음
    }

    //Sub에서 Super의 생성자 호출 > Super의 생성자가 overrideMe라는 인스턴스를 호출
    @Override
    public void overrideMe() {
        //super.overrideMe();
        System.out.println(instant); // 따라서 여기서 시간값이 나와야함을 의도

        // 그러나 실제로는 public으로 열려있는 SUb 생성자를 호출하면 부모의 생성자가 호출됨
        // 부모의 생성자는 ovverrideMe의 메서드를 호출하고
        // ovverrideMe는 override가 되었기 때문에 super의 overrideMe가 아닌 Sub의 OverrideMe를 호출
        // -> 나는 instant 값이 없는데 instant 값을 호출해야 하는 상황 >
        // 결과적으로 생성자 호출시 값 null, overrideMe호출시 값 정상적을 시간값 출력됨
   }
}
