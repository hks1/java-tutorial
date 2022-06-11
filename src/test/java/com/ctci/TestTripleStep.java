package com.ctci;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestTripleStep {
    TripleStep obj;
    @BeforeEach
    public void setUp(){
        obj = new TripleStep();
    }

    public static final Logger logger = Logger.getLogger("");

    private static void logInfo(Description description, String status, long nanos){
        String testName = description.getMethodName();
        logger.info(String.format("Test %s %s, spent %d microseconds",
                testName, status, TimeUnit.NANOSECONDS.toMicros(nanos)));
    }

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        /*@Override
        public long runtime(TimeUnit unit) {
            return super.runtime(unit);
        }*/

        @Override
        protected void succeeded(long nanos, Description description) {
            //super.succeeded(nanos, description);
            logInfo(description, "succeeded", nanos);
        }

        @Override
        protected void failed(long nanos, Throwable e, Description description) {
            //super.failed(nanos, e, description);
            logInfo(description, "failed", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            //super.skipped(nanos, e, description);
            logInfo(description, "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            //super.finished(nanos, description);
            logInfo(description, "finished", nanos);
        }
    };

    @Test
    public void succeeds(){}

    @Test
    public void fails(){
        Assertions.fail();
    }

    @Test
    public void skips(){
        //assumeTrue();
    }

    @Test
    public void performanceTest() throws InterruptedException{
        // An example to assert runtime
        long delta = 30;
        Thread.sleep(300L);
        Assertions.assertEquals(300d, stopwatch.runtime(TimeUnit.MILLISECONDS), delta);
        Thread.sleep(500L);
        Assertions.assertEquals(800d, stopwatch.runtime(TimeUnit.MILLISECONDS), delta);
    }

    @Test
    public void testNumWaysMemoized(){
        //System.out.println("print");
        long start = System.currentTimeMillis();
        Assertions.assertEquals(1, obj.numWaysMemoized(1));
        Assertions.assertEquals(2, obj.numWaysMemoized(2));
        Assertions.assertEquals(4, obj.numWaysMemoized(3));
        Assertions.assertEquals(7, obj.numWaysMemoized(4));
        Assertions.assertEquals(13, obj.numWaysMemoized(5));
        long end = System.currentTimeMillis();
        System.out.println("times with memoization : " + (end - start));
    }
    @Test
    public void testNumWays(){
        //System.out.println("print");
        long start = System.currentTimeMillis();
        Assertions.assertEquals(1, obj.numWays(1));
        Assertions.assertEquals(2, obj.numWays(2));
        Assertions.assertEquals(4, obj.numWays(3));
        Assertions.assertEquals(7, obj.numWays(4));
        Assertions.assertEquals(13, obj.numWays(5));
        long end = System.currentTimeMillis();
        System.out.println("non memoized times : " + (end - start));
    }
    @Test
    public void testNumWaysDP(){
        //System.out.println("print");
        long start = System.currentTimeMillis();
        Assertions.assertEquals(1, obj.numWaysDP(1));
        Assertions.assertEquals(2, obj.numWaysDP(2));
        Assertions.assertEquals(4, obj.numWaysDP(3));
        Assertions.assertEquals(7, obj.numWaysDP(4));
        Assertions.assertEquals(13, obj.numWaysDP(5));
        long end = System.currentTimeMillis();
        System.out.println("top-down DP times : " + (end - start));
    }
}
