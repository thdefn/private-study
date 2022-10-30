package com.haden.prjforstd.tryFinally;

public class Resource implements AutoCloseable{
    //java 7에서 등장한 개념
    @Override
    public void close() throws Exception {
        throw new Exception("inside Resource Exception");
    }
}
