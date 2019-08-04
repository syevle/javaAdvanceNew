package javaPractice.thread.defogexample.ExchengerExample;

import java.util.concurrent.Exchanger;

public class CoffeeThread extends Thread {
    private Exchanger<String> coffeeTalk;
    public CoffeeThread(Exchanger<String> coffeeTalk){
        this.coffeeTalk = coffeeTalk;
    }
    public void run(){
        String reply = null;
        try {
            reply = coffeeTalk.exchange("Hello!");
            System.out.println("Waiter : "+reply);
            reply = coffeeTalk.exchange("Coffee-Latte");
            System.out.println("Waiter : "+reply);
            reply = coffeeTalk.exchange("Regular-One");

        }catch (InterruptedException e){}
    }
}
