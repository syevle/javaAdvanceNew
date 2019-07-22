package javaPractice.thread.scatterGatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String args[]) throws InterruptedException, TimeoutException, ExecutionException {

        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());

        //Creating shared object
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("url 1","1",price));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("url 1","1",price));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("url 1","1",price));

        CompletableFuture<Void> allTask = CompletableFuture.allOf(task1,task2,task3);
        allTask.get(6,TimeUnit.SECONDS);
        System.out.println(price);


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
