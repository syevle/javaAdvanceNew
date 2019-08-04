package javaPractice.thread.defogexample.ExchengerExample;

import java.util.concurrent.Exchanger;

public class WaiterThread extends Thread {
    private Exchanger<String> coffeeTalk;
    public WaiterThread(Exchanger<String> coffeeTalk){
        this.coffeeTalk = coffeeTalk;
    }
    public void run(){
        String reply = null;
        try {
            reply = coffeeTalk.exchange("What would you like to have?");
            System.out.println("Customer : "+reply);
            reply = coffeeTalk.exchange("We have regular,grand & king size," +
                    " Which one you like to have?");
            System.out.println("Customer : "+reply);
            reply = coffeeTalk.exchange("");
            System.out.println("Customer : "+reply);

        }catch (InterruptedException e){}
    }
}
