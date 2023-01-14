package com.haden.prjforstd.effectivejava.immutableclass;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
final class User {
    // 자신을 제외하고는 아무도 가변 컴포넌트에 접근할 수 없도록 한다
    // 배송지의 주소만 바꿀수있는상황
    private final String phone;
    private final List<AddressInfo> addressInfoList; //가변객체

    public List<String> getAdrressList(){
        // 내부에 가변 컴포넌트인 주소 정보를 숨겼다
        // 주소리스트를 참조할 수 없도록 리스트를 줄때 스트링으로 변환하여 반환
        // 어드레스 인포가 내부에 있는지 아니면 객체로 관리가 되어있는지 절대 알수없음
        return addressInfoList.stream().map(AddressInfo::getAddress)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // 대표적인 immutable class - BigInteger
        // 이론적으로 int나 long은 자릿수에 한계가 있는데 얘는 한계가 없음
        /* immutable class의 조건
        1. Thread safe
        2. failure atomicity - 예외 발생 후에도 유효한 상태
        3. 값이 다르면 무조건 독립적인 객체로 생성되어야 함
        * */

        BigInteger bigInteger = new BigInteger("10000");
        // 원래의 bigInteger에 추가되는 것이 아닌 새로운 bigIngteger 인스턴스 반환
        System.out.println(bigInteger.add(new BigInteger("100")));
        // 여전히 우리의 bigInteger은 immutable 하다
        System.out.println(bigInteger);
    }
}
