package javaPractice.thread.CyclicBarrierExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
Java Program to demonstrate how to use CyclicBarrier, Its used when number of threads * needs to wait for each other
before starting again.
 */



public class HelloHP {
    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier barrier = new CyclicBarrier(4);
        Party first = new Party(1000, barrier, "PARTY-1");
        Party second = new Party(2000, barrier, "PARTY-2");
        Party third = new Party(3000, barrier, "PARTY-3");
        Party fourth = new Party(4000, barrier, "PARTY-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

class Party extends Thread {
    private int duration;
    private CyclicBarrier barrier;

    public Party(int duration, CyclicBarrier barrier, String name) {
        super(name);
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is calling await()");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has started running again");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


/*
Output
main has finished
PARTY-1 is calling await()
PARTY-2 is calling await()
PARTY-3 is calling await()
PARTY-4 is calling await()
PARTY-4 has started running again
PARTY-1 has started running again
PARTY-2 has started running again
PARTY-3 has started running again


Read more: http://www.java67.com/2015/06/how-to-use-cyclicbarrier-in-java.html#ixzz4g70eckK8
 */

