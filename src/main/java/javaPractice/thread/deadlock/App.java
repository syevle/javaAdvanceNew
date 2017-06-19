package javaPractice.thread.deadlock;

import javaPractice.thread.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The causes of deadlock and two things you can do about it.
 * This video also covers how to write a method that can safely acquire any number of locks in any order
 * without causing deadlock, using the tryLock() method of ReentrantLock.
 */

public class App {


    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final Runner runner = new Runner();
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    runner.firstThread();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        });

//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    runner.secondThread();
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        });

        Runnable r1 = ()-> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        Runnable r2 = ()-> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        executor.submit(r1);
        executor.submit(r2);


        ConcurrentUtils.stop(executor);

//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();

        runner.finished();
    }

}

/*
Account 1 balance: 13114
Account 2 balance: 6886
Total balance: 20000
 */