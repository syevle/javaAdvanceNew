package javaPractice.thread.defogexample.CountDownLatchExample;

// link : https://nirajsonawane.github.io/2018/06/17/CountDownLatch/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class CountDownLatchWorker implements Runnable
{
    private CountDownLatch countDownLatch;
    private int workerId;

    public CountDownLatchWorker(CountDownLatch countDownLatch ,int workerId) {
        this.countDownLatch=countDownLatch;
        this.workerId=workerId;
    }
    @Override
    public void run() {
        System.out.println("Worker " + workerId + " Started" );
        try {
            Thread.sleep(workerId*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + workerId + " Completed it's work, Reducing  count of countDownLatch " );
        countDownLatch.countDown();
    }
}
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        IntStream.range(1, 6)
                .forEach(cnt -> {
                    newCachedThreadPool.submit(new CountDownLatchWorker(countDownLatch, cnt));
                });
        System.out.println("Main Thread is wating for workers to finish!!!!!!");
        countDownLatch.await();
        System.out.println("Work of All Worker is Completed");
        newCachedThreadPool.shutdown();
    }
}
/*
        Worker 2 Started
        Worker 1 Started
        Worker 3 Started
        Worker 4 Started
        Main Thread is wating for workers to finish!!!!!!
        Worker 5 Started
        Worker 1 Completed it's work, Reducing  count of countDownLatch
        Worker 2 Completed it's work, Reducing  count of countDownLatch
        Worker 3 Completed it's work, Reducing  count of countDownLatch
        Worker 4 Completed it's work, Reducing  count of countDownLatch
        Worker 5 Completed it's work, Reducing  count of countDownLatch
        Work of All Worker is Completed

 */
