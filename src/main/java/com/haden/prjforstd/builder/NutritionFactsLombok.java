package com.haden.prjforstd.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "hiddenBuilder") //처음에 NutritionFactsLombokBuilder으로 만들고 그 다음 롬복 빌더 패턴 사용하겠다
//빌더 메서드 네임을 지정하면 필수값을 받지 않으면 생성 안되도록 제약이 가능함
public class NutritionFactsLombok {
    private final int servingSize; //필수
    private final int servings; //필수
    @Builder.Default private final int calories = 0;
    @Builder.Default private final int fat = 0;
    @Builder.Default private final int solium = 0;
    @Builder.Default private final int carbonhydrate = 0;

    //롬복에서 제거하는 빌더의 특징 : 빌더에 디폴트 값이 없으면 calories = 0, fat = 0 이런거 설정이 가능함

    //필수 요소가 있는 커스텀 메서드 빌더
    public static NutritionFactsLombokBuilder builder(int servingSize, int servings){
        return hiddenBuilder()
                .servingSize(servingSize)
                .servings(servings);
    }
}
