package com.haden.prjforstd.equals;

import java.util.Objects;

public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode,999,"지역코드");
        this.prefix = rangeCheck(prefix,999,"프리픽스");
        this.lineNum = rangeCheck(lineNum,9999,"가입자번호");
    }

    private static short rangeCheck(int val, int max, String arg){
        if(val<0 || val>max){
            throw new IllegalArgumentException(arg+": "+val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

    public int compareTo(PhoneNumber pn){
        int result = Short.compare(areaCode, pn.areaCode);
        if(result == 0){
            result = Short.compare(prefix, pn.prefix);
            if(result == 0){
                result = Short.compare(lineNum, pn.lineNum);
            }
        }
        return result;
    }
}
