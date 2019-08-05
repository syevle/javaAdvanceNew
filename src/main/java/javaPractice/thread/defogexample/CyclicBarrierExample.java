package javaPractice.thread.defogexample;

import java.util.concurrent.*;

/*
Send Message all player at once.
CyclicBarrier send message all player once
 */
public class CyclicBarrierExample {

    public static void main(String args[]) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->System.out.println("All Player Ready."));

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        //Creating Player
        threadPool.submit(new Player("Nitin", cyclicBarrier));
        threadPool.submit(new Player("Ramdas", cyclicBarrier));
        threadPool.submit(new Player("Navnath", cyclicBarrier));
        Thread.sleep(2000);
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
/*
Ramdas is waiting for other player.
Nitin is waiting for other player.
Navnath is waiting for other player.
All Player Ready.
Navnath start playing.
Ramdas start playing.
Nitin start playing.
Nitin is waiting for other player.
Navnath is waiting for other player.
Ramdas is waiting for other player.
 */