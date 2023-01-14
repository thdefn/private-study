package com.haden.prjforstd.effectivejava.inherit;

import java.util.Collection;

public class InstrumentedHashSet <E> extends HashSet<E>{
    private int cnt = 0;
    // add 될때마다 cnt가 추가됨
    // add에서도 cnt가 증가하고 addAll에서도 cnt가 증가함 : 의도한 것의 2배만큼 cnt 증가
    @Override
    public boolean add(E e) {
        cnt++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        cnt += c.size();
        return super.addAll(c); //add가 호출됨
    }
}
