package javaPractice.thread.scatterGatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

public class PhaserExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Set<Integer> price = Collections.synchronizedSet(new HashSet<>());

        Phaser phaser = new Phaser(3);

        //Creating shared object
        threadPool.submit(new Task("url 1","1",price,phaser));
        threadPool.submit(new Task("url 2","2",price,phaser));
        threadPool.submit(new Task("url 3","3",price,phaser));

        phaser.awaitAdvance(1);

        System.out.println(price);

        threadPool.shutdownNow();
    }

    private static class Task implements Runnable{
        private String url;
        private String productId;
        private Set<Integer> price;
        private Phaser phaser;
        public Task(String url,String productId,Set<Integer> price,Phaser phaser){
            this.url =url;
            this.productId=productId;
            this.price=price;
            this.phaser=phaser;
        }

        @Override
        public void run() {
            phaser.arrive();
            price.add(new Random().nextInt());

            System.out.println(url+" "+productId);

        }
    }

}
