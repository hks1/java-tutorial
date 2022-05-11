package com.tutorial.java8;

import java.util.function.BiFunction;

// https://mkyong.com/java8/java-8-bifunction-examples/
// https://mkyong.com/java8/java-8-function-examples/

public class Java8BiFunction3 {
    public static void main(String[] args) {

        GPS obj = factory("40.741895", "-73,989308", GPS::new);
        System.out.println(obj);
    }

    public static <R extends GPS> R factory(String latitude, String longitude,
                                            BiFunction<String, String, R> func){
        return func.apply(latitude, longitude);
    }
}

class GPS{

    String latitude;
    String longitude;

    public GPS(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
