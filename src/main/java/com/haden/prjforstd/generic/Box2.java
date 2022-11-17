package com.haden.prjforstd.generic;

public class Box2<T> {
    private T t;
    public T get(){
        return t;
    }
    public void set(T t){
        this.t = t;
    }
}
