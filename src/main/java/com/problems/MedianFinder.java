package com.problems;

import java.util.PriorityQueue;

// C:\Users\hkson\.jdks\openjdk-15.0.2\bin\java  -cp ./target/classes -ea --enable-preview com.problems.TDMedianFinder
// median from Data Stream
class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;

    public MedianFinder() {
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(10, (a,b) ->  b - a);
    }

    /*public void addNum(int num) {
        // max of first section of the stream
        if(maxQ.size() == 0) {
            maxQ.add(num);
            return;
        }
        // min of second section of the stream
        if(minQ.size() == 0 ) {
            if(maxQ.peek() < num)
                minQ.add(num);
            else{
                minQ.add(maxQ.remove());
                maxQ.add(num);
            }
            return;
        }
        if(num <= maxQ.peek()){
            maxQ.add(num);
        } else{
            minQ.add(num);
        }
        //System.out.println(maxQ.size() + " " + minQ.size());
        //System.out.println(":before while" + maxQ + " " + minQ);
        while(Math.abs(maxQ.size() - minQ.size()) > 1){
            if(minQ.size() > maxQ.size())
                maxQ.add(minQ.remove());
            else
                minQ.add(maxQ.remove());
        }
        //System.out.println(":after while" + maxQ + " " + minQ);
    }*/
    public void addNum(int num) {
        // assumption: maxQ.size() == minQ.size() OR maxQ.size() == minQ.size()
        if(maxQ.size() == 0){
            maxQ.offer(num);
        }else if(num < maxQ.peek()){
            maxQ.offer(num);
            // balance heaps
            if(maxQ.size() > minQ.size() + 1)
                minQ.offer(maxQ.poll());
        }else{
            minQ.offer(num);
            // balance heaps
            if(minQ.size() > maxQ.size())
                maxQ.offer(minQ.poll());
        }
    }

    /*public double findMedian() {
        //System.out.println(maxQ + " " + minQ);
        if(maxQ.size() > minQ.size()) return maxQ.peek();
        else if(minQ.size() > maxQ.size()) return minQ.peek();
        else return (maxQ.peek() + minQ.peek()) / 2.0;
    }*/
    public double findMedian() {
        if(maxQ.size() > minQ.size())
            return maxQ.peek();
        else
            return (maxQ.peek() + minQ.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class TDMedianFinder{
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        double med = obj.findMedian();
        assert med != -0.0 : "test case failed";
        System.out.println("median is" + med);
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());
    }
}

/*
["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
Output:
[null,null,-1.00000,null,-1.50000,null,-1.00000,null,-2.50000,null,-3.00000]
Expected:
[null,null,-1.00000,null,-1.50000,null,-2.00000,null,-2.50000,null,-3.00000]

 */