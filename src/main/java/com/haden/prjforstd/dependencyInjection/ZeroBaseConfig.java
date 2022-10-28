package com.haden.prjforstd.dependencyInjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeroBaseConfig {

    //Property Injection
    //Config class 내부에 직접 값을 할당하는 것은 그만!

    /*
    여러 자원을 활용해야 할 경우 적합하지 않음
    이 상황에서는 환경 (live, dev, local) 별로 다른 값이 들어가야 할 때 적절하지 않음
    리소스를 따로 빼서 injection을 해주는 게 좋다

    private static final String address = "서울시 강남구";

    일종이 DI (property DI) : 디펜던시를 이 config 가 가지지 않고 인젝션 하는 것
    Dependency가 Property에 걸려있고 이 property의 값을 주입함
    application.yml > 정보 등록 @Value($()) 로 가져옴
     */

    /*application.yml에 지정된 값을 어플리케이션 실행할 때 읽어와서
     Configuration에 싱글톤으로 만들어서 해당 값을 주입하는 것 @Value("${}") 을 통해*/

    @Value("${zerobase.address}")
    private String address;


}
