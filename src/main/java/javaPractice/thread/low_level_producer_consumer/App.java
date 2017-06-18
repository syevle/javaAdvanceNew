package javaPractice.thread.low_level_producer_consumer;

import javaPractice.thread.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final Processor processor = new Processor();

//        Thread t1 = new Thread(new Runnable() {
//
//            public void run() {
//                try {
//                    processor.produce();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        Thread t2 = new Thread(new Runnable() {
//
//            public void run() {
//                try {
//                    processor.consume();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });



        Runnable r1 = ()-> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        Runnable r2 = ()-> {
            try {
                processor.consume();
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
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
    }
}