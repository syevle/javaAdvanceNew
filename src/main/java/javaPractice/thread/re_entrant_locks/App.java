package javaPractice.thread.re_entrant_locks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *How to use the ReentrantLock class in Java as an alternative to synchronized code blocks.
 *ReentrantLocks let you do all the stuff that you can do with synchronized, wait and notify,
 *plus some more stuff besides that may come in handy from time to time.
 */

class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        System.out.println("firstThread :: lock.lock()");
        lock.lock();
        System.out.println("firstThread :: Waiting .... cond.await() start");
        cond.await();

        System.out.println("firstThread :: Woken up! cond.await() end");

        try {
            increment();
            System.out.println("firstThread :: increment done");
        } finally {
            lock.unlock();
            System.out.println("firstThread :: lock.unlock() call");
        }
    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        System.out.println("secondThread :: lock.lock()");
        lock.lock();

        System.out.println("secondThread :: Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("secondThread :: Got return key!");

        cond.signal();
        System.out.println("secondThread :: cond.signal() call");

        try {
            increment();
            System.out.println("secondThread :: increment done");
        } finally {
            lock.unlock();
            System.out.println("secondThread :: lock.unlock() call");
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}

public class App {


    public static void main(String[] args) throws Exception {

        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }

}
/*
firstThread :: lock.lock()
firstThread :: Waiting .... cond.await() start
secondThread :: lock.lock()
secondThread :: Press the return key!

secondThread :: Got return key!
secondThread :: cond.signal() call
secondThread :: increment done
secondThread :: lock.unlock() call
firstThread :: Woken up! cond.await() end
firstThread :: increment done
firstThread :: lock.unlock() call
Count is: 20000

 */