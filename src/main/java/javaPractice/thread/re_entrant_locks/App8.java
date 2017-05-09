package javaPractice.thread.re_entrant_locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Predicate {
    void test() throws InterruptedException;

    default void tryTest() {
        try {
            this.test();
        } catch (InterruptedException e) {
            // handle e (log or wrap in a RuntimeException)
        }
    }
}

class MyClass {
    int num = 0;
    Lock lock = new ReentrantLock();

    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("produce");
        for (int i = 0; i < 1000; i++) {
            num++;
            Thread.sleep(1);
        }
        lock.unlock();
    }

    public void consume() throws InterruptedException {
        System.out.println("consume");
        lock.lock();
        for (int i = 0; i < 1000; i++) {
            num--;
            Thread.sleep(1);
        }
        lock.unlock();
    }

    public int getNum() {
        return num;
    }

}

public class App8 {

    public static void main(String[] args) throws InterruptedException {
        MyClass c = new MyClass();
        Predicate prod = c::produce;
        Predicate cons = c::consume;
        Thread t1 = new Thread(() -> prod.tryTest());
        Thread t2 = new Thread(() -> cons.tryTest());
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("time taken " + (end - start) + " num = "
                + c.getNum());
    }
}
