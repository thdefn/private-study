package com.haden.prjforstd.interfaceRefactor;
import static com.haden.prjforstd.interfaceRefactor.TimeConvertUtil.SECONDS_TO_MIN;

public class Me {
    /*코드가 길어지기는 하나 전자의 방법을 더 추천함*/
    public double time1 = TimeConvertUtil.SECONDS_TO_MIN;
    public double time2 = SECONDS_TO_MIN; //같은 상수가 있을 경우 혼란을 일으킬 수 있음
}
