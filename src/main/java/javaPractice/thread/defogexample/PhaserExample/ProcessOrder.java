package javaPractice.thread.defogexample.PhaserExample;

import java.util.concurrent.Phaser;

class Worker extends Thread {
    Phaser workPhaser;
    Worker(Phaser workPhaser,String name){
        this.setName(name);
        this.workPhaser = workPhaser;
        workPhaser.register();
        this.start();
    }

    public void run(){
        for (int i = 1;i<=3;i++){
            System.out.println(getName()+" doing this work for order "+i);
            if(i==3){// no food item.
                workPhaser.arriveAndDeregister();
                //work complet and move to next order.
            }else {
                workPhaser.arriveAndAwaitAdvance();
                // wait for other to complet their work.
            }
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


public class ProcessOrder {
    public static void main(String[] args) {
        Phaser delOrder = new Phaser(1);
        System.out.println("Starting to process the order.");
        new Worker(delOrder,"cook");
        new Worker(delOrder,"waiter");
        new Worker(delOrder,"attendent");

        for(int i=1;i<=3;i++){
            delOrder.arriveAndAwaitAdvance();
            System.out.println("Order "+i+" completed");
        }

        delOrder.arriveAndDeregister();
        System.out.println("Process completed");

    }
}
/*
Starting to process the order.
cook doing this work for order 1
waiter doing this work for order 1
attendent doing this work for order 1
Order 1 completed
attendent doing this work for order 2
waiter doing this work for order 2
cook doing this work for order 2
Order 2 completed
cook doing this work for order 3
attendent doing this work for order 3
waiter doing this work for order 3
Order 3 completed
Process completed
 */