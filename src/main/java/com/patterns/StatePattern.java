package com.patterns;

public class StatePattern {
}

class Phone{
    RingState s = new SoundState();

    void ring(){
        s.ring();
    }

    void volumUp() { s = s.nextStateVolumeUp(); }
    void volumeDown() { s = s.nextStateVolumeDown(); }
}

abstract class RingState{
    abstract void ring();
    abstract RingState nextStateVolumeUp();
    abstract RingState nextStateVolumeDown();
}

class SoundState extends RingState{
    void ring() {
        System.out.println("Phone is ringing");
    }

    @Override
    RingState nextStateVolumeUp() {
        return this;
    }

    @Override
    RingState nextStateVolumeDown() {
        return new VibrantState();
    }
}

class VibrantState extends RingState{
    void ring() {
        System.out.println("Phone is vibrating");
    }

    @Override
    RingState nextStateVolumeDown() {
        return new SilentState();
    }

    @Override
    RingState nextStateVolumeUp() {
        return new SoundState();
    }
}

class SilentState extends RingState{
    void ring() {
        System.out.println("...");
    }

    @Override
    RingState nextStateVolumeUp() {
        return new VibrantState();
    }

    @Override
    RingState nextStateVolumeDown() {
        return this;
    }
}

class TestStatePattern{
    public static void main(String[] args) {
        Phone p = new Phone();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumUp();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();
        p.ring();
    }
}
