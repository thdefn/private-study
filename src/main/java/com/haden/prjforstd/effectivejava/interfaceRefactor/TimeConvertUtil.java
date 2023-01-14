package com.haden.prjforstd.effectivejava.interfaceRefactor;

public class TimeConvertUtil {
    public static final double SECONDS_TO_MIN = 60;
    public static double secondToMin(double second){
        return second/SECONDS_TO_MIN;
    }
}
