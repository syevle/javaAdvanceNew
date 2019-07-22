package javaPractice.thread.scatterGatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
This Solution Implements using simple Thread.
Retrieve price from N sources, waiting from max 3 second.
 */

public class SimpeThread {
    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());
        //Creating shared object
        threadPool.submit(new Task("url 1","1",price));
        threadPool.submit(new Task("url 2","2",price));
        threadPool.submit(new Task("url 3","3",price));

        Thread.sleep(5000);

        System.out.println(price);

        threadPool.shutdownNow();
    }

    private static class Task implements Runnable{
        private String url;
        private String productId;
        private Set<Integer> price;
        public Task(String url,String productId,Set<Integer> price){
            this.url =url;
            this.productId=productId;
            this.price=price;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            price.add(new Random().nextInt());
            System.out.println(url+" "+productId);
        }
    }

}

