package com.haden.prjforstd.effectivejava.tryFinally;

import java.io.*;

import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;

public class TrywithResources {
    public void updateScore(){
        //1이 먼저 나오고 익셉션이 던져짐 BUT 익셉션의 유무와 상관없이 try 블록 종료되고 finally 블록 실행됨
        // 1 3
        try{
            System.out.println("1");
            throw new RuntimeException((String) null);
        }  finally {
            System.out.println("3");
        }

        /*try(Resource r1 = new Resource(); Resource r2 = new Resource();){
            throw new RuntimeException((String) null);
        } */
    }

    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            return br.readLine();
        }finally {
            br.close();
        }
    }

    //지저분한 finally
    //결함이 있지는 않지만 에러 추적시 리드가 실패하면 익셉션 발생해서 finally로
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try{
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[100];
                int n;
                while ((n=in.read(buf))>=0){ //1. 여기서 실패 익셉션
                    out.write(buf,0,n);
                }
            }finally { //2. 이 위치로
                out.close(); //근데 이것도 실패 또 익셉션
            }
        }finally { //3. 이 위치로
            in.close(); //내부 클러즈가 바랫오댔던 에러가 오버라이드 느낌으로 덮어씌어짐 >
            // 어디서 에러 발생했는지 추적 어려움
        }

    }

    static String firstLineOfFile2(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    static void copy2(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[100];
            int n;
            while ((n=in.read(buf))>=0){ //1. 여기서 실패 익셉션
                out.write(buf,0,n);
            }
        }
    }


}
