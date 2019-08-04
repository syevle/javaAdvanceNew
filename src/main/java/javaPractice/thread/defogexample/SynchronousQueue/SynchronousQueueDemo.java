package javaPractice.thread.defogexample.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();
        Thread washer = new Thread("Washer"){
                public void run(){
                    try {
                        queue.put(Thread.currentThread().getName());
                        System.out.println("Wash dish number : "+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        };

        Thread dryer = new Thread("Dryer"){
            public void run(){
                try {
                    System.out.println("Dryer dish number : "+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        washer.start();
        dryer.start();


    }
}
