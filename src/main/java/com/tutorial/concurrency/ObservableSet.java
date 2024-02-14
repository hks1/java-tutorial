package com.tutorial.concurrency;

import java.util.*;

public class ObservableSet<E> extends AbstractSet<E> {

    public ObservableSet(Set<E> set) {
        //super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer){
        synchronized (observers){
                   observers.add(observer);
        }
    }

    public void removeObserver(SetObserver<E> observer){
        synchronized (observers){
            observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers){
            for(SetObserver<E> observer : observers){
                observer.added(this, element);
            }
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if(added){
            notifyElementAdded(e);
        }
        return added;
        //return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E element : c){
            result = add(element); // calls notifyElementAdded
        }
        return result;
        //return super.addAll(c);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

