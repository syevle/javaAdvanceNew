package javaPractice.thread.defogexample.ExchengerExample;

// Link : https://nirajsonawane.github.io/2018/06/18/Exchanger/

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FirstThread implements Runnable {
    private Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("Passing information form FirstThread");
            Integer exchange = exchanger.exchange(99);
            System.out.println("Information Sent From FirstThread");
            System.out.println("Received information from Second Thread." + exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SecondThread implements Runnable {
    private Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        System.out.println("Receiving information from First Thread.");
        try {

            Integer exchange = exchanger.exchange(2);
            System.out.println("Received information from first Thread." + exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(new FirstThread(exchanger));
        newFixedThreadPool.submit(new SecondThread(exchanger));
        newFixedThreadPool.shutdown();
    }
}

/*
Passing information form FirstThread
Receiving information from First Thread.
Received information from first Thread.99
Information Sent From FirstThread
Received information from Second Thread.2
 */