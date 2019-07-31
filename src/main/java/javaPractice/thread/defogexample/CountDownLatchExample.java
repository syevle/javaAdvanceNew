package javaPractice.thread.defogexample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public static void main(String args[]) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        //Creating shared object
        threadPool.submit(new DependentSevice("Cache Service",1000,latch));
        threadPool.submit(new DependentSevice("DB Service",2000,latch));
        threadPool.submit(new DependentSevice("Cassandra Service",3000,latch));
        System.out.println("Main Thread wait for other Service to complet has work");
        latch.await(5, TimeUnit.SECONDS);
        System.out.println("All service started. and main thread started");
        threadPool.shutdown();
    }

    private static class DependentSevice implements Runnable{
        private String seviceName;
        private int serviceUpTime;
        private CountDownLatch latch;
        public DependentSevice(String seviceName,int serviceUpTime,CountDownLatch latch){
            this.seviceName =seviceName;
            this.serviceUpTime = serviceUpTime;
            this.latch=latch;
        }

        @Override
        public void run() {
            longRunningSevice(serviceUpTime);
            latch.countDown();
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
/*

Started service : Cache Service
Started service : DB Service
Started service : Cassandra Service
All service started.
 */