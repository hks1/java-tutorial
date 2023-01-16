# Observer Pattern
<!-- https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java -->

- __behavioral design pattern__
- When you are interested in the state of an object and want to get notified whenever there is any change
- The object watch no the state of another object is called __Observer__ and the object that is being watched is called __Subject__

According to GoF, observer design pattern intent is;

>Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.


__Subject__ contains the list of observers to notify of any change in its state, so it should provide methods using which observers can register and unregister themselves.

Subject also contain a method to notify all the observers of any change and either it can send the update while notifying the observer or it can provide another method to get the update.

Observer should have a method to set the object to watch and another method that will be used by Subject to notify them of any updates.

Java provides inbuilt platform for implementing Observer pattern through java.util.Observable class and java.util.Observer interface.
<!-- However it’s not widely used because the implementation is really simple and most of the times we don’t want to end up extending a class just for implementing Observer pattern as java doesn’t provide multiple inheritance in classes. -->

Java Message Service (JMS) uses __Observer design pattern__ along with [Mediator pattern](https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java) to allow applications to subscribe and publish data to other applications.

Model-View-Controller (MVC) frameworks also use Observer pattern where Model is the Subject and Views are observers that can register to get notified of any change to the model.

## Example
We would implement a simple topic and observers can register to this topic.
Whenever any new message will be posted to the topic, all the registers observers will be notified and they can consume the message.

Based on the requirements of Subject, here is the base Subject interface that defines the contract methods to be implemented by any concrete subject.

```java
package com.hks.design.patterns.observer;

public interface Subject {
    // methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    // method to notify observers of change
    public void notifyObservers();

    // method to get updates from subject
    public Object getUpdate(Observer obj);
}

```

Contract for Observer
- a method to attach the Subject to the observer, and 
- another method to be used by Subject to notify of any change.

```java
package com.hks.design.patterns.observer;

public interface Observer {
    // method to update the observer, used by subject
    public void update();

    // attach with subject to observe
    public void setSubject(Subject sub);
}

```

concrete implementation of topic
- postMessage() - used by client application to post String message to the topic
- boolean variable - to keep track of the change in the state of the topic and used in notifying the observers
- use of [synchronization](https://www.digitalocean.com/community/tutorials/thread-safety-in-java) in notifyObservers() method to make sure the notification is sent only to the observers registered before the message is published to the topic.

```java
package com.hks.design.patterns.observer;


import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject{
    private List<Observer> observerList;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyTopic(){
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX){
            if(!observerList.contains(obj)) observerList.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX){
            observerList.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        // synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX){
            if(!changed)
                return;
            observersLocal = new ArrayList<>(this.observerList);
            this.changed = false;
        }
        for (Observer obj : observersLocal){
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    // method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message posted to topic: "+ msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }
}

```

implementation of Observers that will watch over the subject
```java
package com.hks.design.patterns.observer;

public class MyTopicSubscriber implements Observer{
    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name){
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if (msg == null)
            System.out.println(name+":: No new message");
        else
            System.out.println(name+":: Consuming message:: "+ msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic = sub;
    }
}

```

test program
```java
package com.hks.design.patterns.observer;

public class ObserverPatternTest {
    public static void main(String[] args) {
        // create subject
        MyTopic topic = new MyTopic();

        // create observers
        Observer obj1 = new MyTopicSubscriber("obj1");
        Observer obj2 = new MyTopicSubscriber("obj2");
        Observer obj3 = new MyTopicSubscriber("obj3");

        // register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // attach observers to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        // check if any update is available
        obj1.update();

        // now send message to subject
        topic.postMessage("New Message");
    }
}

```

## Class Diagram