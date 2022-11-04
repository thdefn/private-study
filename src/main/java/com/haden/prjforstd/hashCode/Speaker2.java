package com.haden.prjforstd.hashCode;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;

public class Speaker2 {
    private final String message;

    public Speaker2(String message) {
        this.message = message;
    }

    //hashCode 메서드를 사용하지 않고 실행한다면?
    public static void main(String[] args) {
        Speaker2 speaker = new Speaker2("수업 시작 시간입니다.");
        Map<Speaker2, LocalTime> localTimeMap = new HashMap<>();
        localTimeMap.put(speaker, LocalTime.of(9,0));

        // LocalTime에 대한 변경을 하고 싶은 경우 개발자는 Speaker2 객체를 통해 hashmap에서 식별하려고 함

        Speaker2 speaker2 = new Speaker2("수업 시작 시간입니다.");
        localTimeMap.put(speaker2, LocalTime.of(8,50));

        //실제로는 안내 방송이 8:50 9:00 두번 울리게 됨
        //두 객체의 해시코드의 값이 다르기 때문에
    }

    // 가장 simle한 방식 각 필드에 대해 해시코드를 구하고 그걸 연산하는 방법
    /*@Override
    public int hashCode() {
        int result = message.hashCode();
        return result;
    }*/


    // Objects.hash()를 호출 : 속도가 많이 느려지면 lazyinit or caching을 고려하자
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }


}
