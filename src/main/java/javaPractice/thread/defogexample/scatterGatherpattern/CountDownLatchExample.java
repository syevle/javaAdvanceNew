package javaPractice.thread.defogexample.scatterGatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());

        CountDownLatch latch = new CountDownLatch(3);

        //Creating shared object
        threadPool.submit(new Task("url 1","1",price,latch));
        threadPool.submit(new Task("url 2","2",price,latch));
        threadPool.submit(new Task("url 3","3",price,latch));

        latch.await(3, TimeUnit.SECONDS);

        System.out.println(price);

        threadPool.shutdownNow();
    }

    private static class Task implements Runnable{
        private String url;
        private String productId;
        private Set<Integer> price;
        private CountDownLatch latch;
        public Task(String url,String productId,Set<Integer> price,CountDownLatch latch){
            this.url =url;
            this.productId=productId;
            this.price=price;
            this.latch=latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            price.add(new Random().nextInt());
            latch.countDown();
            System.out.println(url+" "+productId);

        }
    }

}
