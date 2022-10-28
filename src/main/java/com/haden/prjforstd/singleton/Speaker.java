package com.haden.prjforstd.singleton;

public class Speaker {
    // 싱글톤 : 객체의 인스턴스를 하나만 가져갈것이다

    //public static final member을 사용하는 방법
    //인스턴스를 초기화 시키고 바로 고정해서 변하지 않게

    /*
    public static final Speaker INSTANCE = new Speaker(); // INSTANCE는 일종의 개발자끼리 규약 이건 일종의 상수구나 ~

    //생성자를 private으로 만들어서 사용자가 호출할 수 없게함 : 의도하지 않은 객체 생성을 막음
    private Speaker(){
    }*/

    //private static final member을 사용하는 방법 : 변수에 직접 접근할 수 없게 막음
    //장점이 많음
    /*private static final Speaker INSTANCE = new Speaker();
    private Speaker(){}

    //이 메서드를 통해 인스턴스를 가져오게
    public static Speaker getInstance(){
        return INSTANCE;
    }*/


    //인스턴스가 필요할지에 대해 장담할 수 없는 경우 synchronized or lazy하게 instance를 생성
    //private static final이 아니기 때문에 변동이가능함
    private static Speaker instance;
    private Speaker(){}
    //하나뿐인 커넥션 공유 - 일정시간 사용하지 않는 경우 커넥션을 끊는다
    //인스턴스가 null일때 새로운 인스턴스를 할당 가능함;
    public static synchronized Speaker getInstance(){
        if(instance == null){
            instance = new Speaker();
        }
        return instance;
    }

    //처음 서비스를 띄우는 상황
    //인스턴스에 null이 들어가 있음
    // 이제 DB 연결이 필요할 것 같아 - DB와 연결된 인스턴ㅅ 필요 > 그 때 getINstance() 호출시 그때만 커넥션 생성이 가능함
    // DB에서 3분동안 사용하지 않으면 강제로 연결을 끊음 > 인스턴스 생성해서 가져올 수 있음





}
