package com.hks.design.patterns.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter{
    //Using composition for Adapter Pattern
    private Socket socket ;
    public SocketObjectAdapterImpl(){
        socket = new Socket();
    }
    public SocketObjectAdapterImpl(Socket s){
        this.socket = s;
    }
    @Override
    public Volt get120Volt() {
        return socket.getVolts();
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolts();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = socket.getVolts();
        return convertVolt(v, 40);
    }

    public Volt convertVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}
