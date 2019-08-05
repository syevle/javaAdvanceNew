package javaPractice.thread.defogexample.PhaserExample;

import java.util.concurrent.*;
// phaser use as countdownlach
public class PhaserCountDownLatchExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Phaser phaser = new Phaser(3);

        //Creating shared object
        threadPool.submit(new DependentSevice("Cache Service",1000,phaser));
        threadPool.submit(new DependentSevice("DB Service",2000,phaser));
        threadPool.submit(new DependentSevice("Cassandra Service",3000,phaser));
        phaser.awaitAdvance(1);
        System.out.println("All service started.");
        threadPool.shutdown();
//        threadPool.awaitTermination(1,TimeUnit.MINUTES);

    }

    private static class DependentSevice implements Runnable{
        private String seviceName;
        private int serviceUpTime;
        private Phaser phaser;
        public DependentSevice(String seviceName,int serviceUpTime,Phaser phaser){
            this.seviceName =seviceName;
            this.serviceUpTime = serviceUpTime;
            this.phaser=phaser;
        }

        @Override
        public void run() {
            longRunningSevice(serviceUpTime);
            phaser.arrive();
            System.out.println("Started service : "+ seviceName);

        }

        private void longRunningSevice(int serviceUpTime) {
            try {
                Thread.sleep(serviceUpTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
