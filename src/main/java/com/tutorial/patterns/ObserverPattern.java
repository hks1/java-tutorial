package com.tutorial.patterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
}
// also called public-subscribe pattern

class MobilePhone{
    double lon, lat;
    List<Observer> os = new ArrayList<>();
    void move(){
        lon += 3.0;
        lat += 5.0;
        notifyLocationChanged();
    }

    void register(Observer o){
        os.add(o);
    }
    private void notifyLocationChanged(){
        os.stream().forEach((o -> o.update(lon, lat)));
    }
}

interface Observer{
    abstract void update(double lon, double lat);
}

class MobileApp implements Observer{
    @Override
    public void update(double lon, double lat) {
        System.out.println(lat + " " + lon);
    }
}

class TestObserverPattern{
    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        phone.register(new MobileApp());
        phone.move();
        phone.move();
        phone.move();
    }
}