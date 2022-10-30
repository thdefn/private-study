package com.haden.prjforstd.tryFinally;

public class Boss {
    public static class Worker implements AutoCloseable{

        public String work(){
            throw new RuntimeException("work Exception");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("close Resource Exception");
        }
    }

    public static void main(String[] args) {
        try(Worker worker = new Worker()){
            worker.work();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
