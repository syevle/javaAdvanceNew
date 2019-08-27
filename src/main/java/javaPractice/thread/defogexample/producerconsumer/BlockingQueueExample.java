package javaPractice.thread.defogexample.producerconsumer;

//https://www.baeldung.com/java-blocking-queue

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BlockingQueueProducer implements Runnable
{
    private java.util.concurrent.BlockingQueue<Integer> blockingQueue;
    private Random random;
    public BlockingQueueProducer(java.util.concurrent.BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
        this.random = new Random();

    }
    @Override
    public void run() {
        while(true)
        {
            System.out.println("BlockingQueueProducer - Adding Elements");
            try {
                blockingQueue.put(random.nextInt(3000));
                System.out.println("Added Element : Current Size of Q " + blockingQueue.size());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BlockingQueueConsumer implements Runnable
{
    java.util.concurrent.BlockingQueue<Integer> blockingQueue;
    public BlockingQueueConsumer(java.util.concurrent.BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while (true) {

            try {
                System.out.println("BlockingQueueConsumer : iteam recived from Q " + blockingQueue.take() );
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class BlockingQueueExample {

    public static void main(String[] args) {
        java.util.concurrent.BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(5);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(new BlockingQueueConsumer(blockingQueue));
        newFixedThreadPool.submit(new BlockingQueueProducer(blockingQueue));
        newFixedThreadPool.shutdown();
    }
}


/*
BlockingQueueProducer - Adding Elements
BlockingQueueConsumer : iteam recived from Q 222
Added Element : Current Size of Q 0
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 1
BlockingQueueConsumer : iteam recived from Q 1728
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 1
BlockingQueueConsumer : iteam recived from Q 155
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 1
BlockingQueueConsumer : iteam recived from Q 2863
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 1
BlockingQueueConsumer : iteam recived from Q 790
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 1
BlockingQueueProducer - Adding Elements
Added Element : Current Size of Q 2
BlockingQueueConsumer : iteam recived from Q 29
 */