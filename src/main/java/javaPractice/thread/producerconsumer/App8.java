package javaPractice.thread.producerconsumer;

/**
 *A tutorial on how to implement the producer-consumer pattern in Java using the ArrayBlockingQueue Java class.
 * Producer-Consumer is the situation where one or more threads are producing data items and adding them to a shared data
 * store of some kind while one or more other threads process those items, removing them from the data store.
 */

import javaPractice.thread.ConcurrentUtils;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App8 {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable t1 = ()->{
                try {
                    producer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };
        Runnable t2 = ()->{
            try {
                consumer();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };
        executor.submit(t1);
        executor.submit(t2);
        ConcurrentUtils.stop(executor);
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while(true) {
            Integer value = random.nextInt(100);
            queue.put(value);
            System.out.println("Put value: " + value + "; Queue size is: " + queue.size());
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();

        while(true) {
            Thread.sleep(100);

            if(random.nextInt(10) == 0) {
                Integer value = queue.take();

                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}

/*
Put value: 54; Queue size is: 1
Put value: 71; Queue size is: 2
Put value: 29; Queue size is: 3
Put value: 8; Queue size is: 4
Put value: 85; Queue size is: 5
Put value: 87; Queue size is: 6
Put value: 52; Queue size is: 7
Put value: 66; Queue size is: 8
Put value: 10; Queue size is: 9
Put value: 3; Queue size is: 10
Taken value: 54; Queue size is: 9
Put value: 42; Queue size is: 10
Taken value: 71; Queue size is: 9
Put value: 3; Queue size is: 10
Taken value: 29; Queue size is: 9
Put value: 69; Queue size is: 10
Taken value: 8; Queue size is: 10
Put value: 0; Queue size is: 10
Taken value: 85; Queue size is: 9
Put value: 99; Queue size is: 10
Taken value: 87; Queue size is: 9
Put value: 1; Queue size is: 10
Taken value: 52; Queue size is: 9
Put value: 50; Queue size is: 10
Taken value: 66; Queue size is: 9
Put value: 44; Queue size is: 10
Taken value: 10; Queue size is: 9
Put value: 59; Queue size is: 10
Put value: 0; Queue size is: 10
Taken value: 3; Queue size is: 10
Taken value: 42; Queue size is: 9
Put value: 63; Queue size is: 10
Taken value: 3; Queue size is: 9
Put value: 21; Queue size is: 10
Taken value: 69; Queue size is: 9
Put value: 67; Queue size is: 10
Taken value: 0; Queue size is: 9
Put value: 49; Queue size is: 10
Taken value: 99; Queue size is: 9
 */