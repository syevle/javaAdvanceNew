package javaPractice.thread.defogexample.Phaser;

import java.util.concurrent.*;

/*
Send Message all player at once.
Phaser use as cyclicbarier send message all player once
 */
public class PhaserCyclicBarrierExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);

        //Creating Player
        threadPool.submit(new Player("Nitin", phaser));
        threadPool.submit(new Player("Ramdas", phaser));
        threadPool.submit(new Player("Navnath", phaser));
        Thread.sleep(2000);
        System.out.println("All player start playing.");
        threadPool.shutdown();
    }

    private static class Player implements Runnable {
        private String name;
        private Phaser phaser;

        public Player(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println(name+" is waiting for other player.");
                    Thread.sleep(2000);
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name+" start playing.");
            }
        }
    }

}
