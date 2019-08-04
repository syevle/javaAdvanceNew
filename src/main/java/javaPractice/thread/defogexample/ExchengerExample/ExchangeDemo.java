package javaPractice.thread.defogexample.ExchengerExample;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<String>();
        new CoffeeThread(ex).start();
        new WaiterThread(ex).start();
    }
}
/*
Customer : Hello!
Waiter : What would you like to have?
Customer : Coffee-Latte
Waiter : We have regular,grand & king size, Which one you like to have?
Customer : Regular-One
 */