package com.haden.prjforstd.classHierarchy;

public class DeliveryPerson extends ImporvedUser{
    double latitude;
    double longtitude;

    public DeliveryPerson(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    @Override
    boolean order(String info) {
        // 배달 수락 버튼 누를 시 승락
        return false;
    }
}
