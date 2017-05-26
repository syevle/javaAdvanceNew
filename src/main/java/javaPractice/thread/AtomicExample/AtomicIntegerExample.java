package javaPractice.thread.AtomicExample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Santosh on 5/26/17.
 */
public class AtomicIntegerExample {

    private static AtomicInteger at = new AtomicInteger(0);

    static class MyRunnable implements Runnable {

        private int myCounter;
        private int myPrevCounter;
        private int myCounterPlusFive;
        private boolean isNine;

        public void run() {
            myCounter = at.incrementAndGet();
            System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + myCounter);
            myPrevCounter = at.getAndIncrement();
            System.out.println("Thread " + Thread.currentThread().getId() + " / Previous : " + myPrevCounter);
            myCounterPlusFive = at.addAndGet(5);
            System.out.println("Thread " + Thread.currentThread().getId() + " / plus five : " + myCounterPlusFive);
            isNine = at.compareAndSet(9, 3);
            if (isNine) {
                System.out.println("Thread " + Thread.currentThread().getId()
                        + " / Value was equal to 9, so it was updated to " + at.intValue());
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}

/*
Thread 11  / Counter : 1
Thread 12  / Counter : 2
Thread 11 / Previous : 2
Thread 12 / Previous : 3
Thread 12 / plus five : 14
Thread 11 / plus five : 9
 */
