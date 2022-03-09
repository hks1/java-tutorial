package com.tutorial.lambda;

// Lambda Expressions vs. Anonymous Interface Implementations

public interface MyEventConsumer {

    public void consume(Object event);
}

class Main{

    // This interface can be implemented using an anonymous interface implementation, like this:
    public static void main(String[] args) {
        MyEventConsumer consumer = new MyEventConsumer() {
            @Override
            public void consume(Object event) {
                System.out.println(event.toString() + " consumed");
            }
        };

        // This anonymous MyEventConsumer implementation can have its own internal state.
        // Look at this redesign:
        MyEventConsumer consumer1 = new MyEventConsumer() {
            private int eventCount = 0;
            @Override
            public void consume(Object event) {
                System.out.println(event.toString() + " consumed " + this.eventCount++ + " times.");
            }
        };

        // Notice how the anonymous MyEventConsumer implementation has a field named eventCount.
        // A lambda expression cannot have such fields.
        // A lambda expression is thus said to be STATELESS.

        consumer.consume("READY");
        consumer1.consume("FINISH");
        consumer1.consume("RESTARTED");
    }


}
