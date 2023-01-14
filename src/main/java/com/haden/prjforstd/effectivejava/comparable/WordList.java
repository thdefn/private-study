package com.haden.prjforstd.effectivejava.comparable;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
    public static void main(String[] args) {
        String[] strs = new String[]{"cd","ab","de","ee","be"};
        Set<String> s = new TreeSet<>(); //새로운 String으로 이루어진 Treeset 배열 s 생성
        Collections.addAll(s, strs); //시스템 입력을 s에 담음 ex> Collections.addAll(list, elements)
        System.out.println(s);

        /*
        Collections : 정렬 알고리즘을 사용하는 유틸리티 클래스
        TreeSet : 정렬된 컬렉션
        TreeMap : 정렬된 컬렉션
        정렬된 컬렉션은 동치성을 비교할 때 compareTo를 사용함 > HashSet은 equals
        * */

        Integer one = 1;
        System.out.println(one.compareTo(2));
    }
}
