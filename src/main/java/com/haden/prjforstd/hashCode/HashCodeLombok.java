package com.haden.prjforstd.hashCode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HashCodeLombok {
    private transient int transientVar = 10;
    private String name;
    private double score;
    private String[] tags;
    @EqualsAndHashCode.Exclude private int id; //hashcode 연산에 제외하고자 하는 필드

    /*
    * @Data 를 권장하지 않는 이유
    * @Data = @Getter + @Setter + @RequriedArgConstructor + @ToString + @EqualsAndHashCode
    * 의도하지 않는 어노테이션이 빨려들어가서 불필요한 코드들을 만들어 낼 수 있음
    * */
}
