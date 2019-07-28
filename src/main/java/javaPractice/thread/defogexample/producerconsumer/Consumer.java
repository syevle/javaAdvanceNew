package javaPractice.thread.defogexample.producerconsumer;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Santosh on 6/19/17.
 */
class Consumer implements Runnable{

    private final BlockingQueue<Integer> sharedQueue;

    public Consumer (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
