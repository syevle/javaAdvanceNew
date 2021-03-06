package javaPractice.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BlockingQueue amazingly simplifies implementation of Producer-Consumer design pattern by providing outofbox
 * support of blocking on put() and take(). Developer doesn't need to write confusing and critical piece of wait-notify code
 * to implement communication. BlockingQuue is an interface and Java 5 provides different implantation like ArrayBlockingQueue
 * and LinkedBlockingQueue , both implement FIFO order or elements, whileArrayLinkedQueue is bounded in nature LinkedBlockingQueue
 * is optionally bounded. here is a complete code example of Producer Consumer pattern with BlockingQueue.
 * Compare it with classic wait notify code, its much simpler and easy to understand.
 */
public class ProducerConsumerPattern {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }

}

/*
=========== Output: ============
Produced: 0
Produced: 1
Produced: 2
Consumed: 0
Produced: 3
Consumed: 1
Produced: 4
Consumed: 2
Produced: 5
Consumed: 3
Produced: 6
Consumed: 4
Produced: 7
Consumed: 5
Produced: 8
Consumed: 6
Consumed: 7
Produced: 9
Consumed: 8
Consumed: 9

 */
