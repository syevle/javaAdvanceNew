package javaPractice.thread.semaphores;

import java.util.concurrent.Semaphore;

/**
 * Counting Semaphore Example in Java (Binary Semaphore)

 a Counting semaphore with one permit is known as binary semaphore because it has only two state permit available or permit unavailable.
 Binary semaphore can be used to implement mutual exclusion or critical section where only one thread is allowed to execute.
 Thread will wait on acquire() until Thread inside critical section release permit by calling release() on semaphore.
 */
public class BinarySemaphore {

    Semaphore binary = new Semaphore(1);

    public static void main(String args[]) {
        final BinarySemaphore test = new BinarySemaphore();
        new Thread(){
            @Override
            public void run(){
                test.mutualExclusion();
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                test.mutualExclusion();
            }
        }.start();

    }

    private void mutualExclusion() {
        try {
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }

}
/*
OuptPut :
Thread-0 inside mutual exclusive region
Thread-0 outside of mutual exclusive region
Thread-1 inside mutual exclusive region
Thread-1 outside of mutual exclusive region

 */