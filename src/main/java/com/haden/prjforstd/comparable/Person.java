package com.haden.prjforstd.comparable;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Person {
    /*
    1순위는 나이로 정렬 2순위는 name으로 정렬 3순위는 height으로 정렬
    * */
    private int age;
    private String name;
    private double height;

    //COMPARATOR을 생성하는 메서드를 활용하는 방법
    //간결해질 수 있고 Stream을 이용해서 사용할 수 있따는 게 장점일 수 있음 또 직관적임
    private static final Comparator<Person> COMPARATOR = Comparator.comparingInt(Person::getAge)
            .thenComparing(person -> person.getName()).thenComparingDouble(Person::getHeight);
    //비교자를 만들건데 Person type을 비교할거고, 이 비교자는 Int Type으로 처음엔 person의 getAge를 비교하고, then getname을 비교하고

    /*public int compareTo(Person p){
        int result = Integer.compare(age, p.age);
        if(result == 0){
            result = name.compareTo(p.name);
            if(result == 0){
            result = Double.compare(height, p.height);
            }
        }

        return result;
    }*/

    public int compareTo(Person p){
        return COMPARATOR.compare(this,p);
    }

    public static void main(String[] args) {
        Person person = new Person(19,"Haden",168);
        Person person2 = new Person(20,"eden",160);
        Person person3 = new Person(20,"eden",162);

        System.out.println(person.compareTo(person2));
        System.out.println(person.compareTo(person3));
        System.out.println(person2.compareTo(person));
        System.out.println(person.compareTo(person));
    }

}
