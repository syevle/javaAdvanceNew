package javaPractice.thread.defogexample;

import java.util.concurrent.*;

/*
Send Message all player at once.
CyclicBarrier send message all player once
 */
public class CyclicBarrierExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        //Creating Player
        threadPool.submit(new Player("Nitin", cyclicBarrier));
        threadPool.submit(new Player("Ramdas", cyclicBarrier));
        threadPool.submit(new Player("Navnath", cyclicBarrier));
        Thread.sleep(2000);
        System.out.println("All player start playing.");
        threadPool.shutdown();
    }

    private static class Player implements Runnable {
        private String name;
        private CyclicBarrier cyclicBarrier;

        public Player(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println(name+" is waiting for other player.");
                    Thread.sleep(2000);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(name+" start playing.");
            }
        }
    }

}
