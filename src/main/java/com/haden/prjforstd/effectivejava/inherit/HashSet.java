package com.haden.prjforstd.effectivejava.inherit;

import java.util.Collection;

public class HashSet<E> {
    // HashSet의 내부의 일부를 복원해본 코드
    public boolean add(E e){
        return true;
    }
    public boolean addAll(Collection<? extends E> c){
        // addall이 내부에서 add를 호출함
        // 이경우 해시셋을 확장해서 add를 오버라이드하면 addall 메서드가 내가 생각한것처럼 동작 x
        c.forEach(d->add(d));
        return true;
    }
}
