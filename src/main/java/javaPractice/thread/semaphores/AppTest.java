package javaPractice.thread.semaphores;

/**
 *App.java: creates 200 threads and fires them off simultaneously.
 * They all try to run the connect() method of the Connection class at the same time.
 */

import java.util.concurrent.Semaphore;


public class AppTest {

    public static void main(String[] args) throws Exception {
//        Semaphore sem = new Semaphore(0);
        Semaphore sem = new Semaphore(1);

        sem.acquire();

        sem.release();

        System.out.println("Avilable permits : "+sem.availablePermits());
    }

}

/*
Avilable permits : 1
 */