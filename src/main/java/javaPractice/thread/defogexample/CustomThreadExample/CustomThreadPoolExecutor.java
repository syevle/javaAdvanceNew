package javaPractice.thread.defogexample.CustomThreadExample;

/*
Link https://www.javacodemonk.com/implement-thread-pool-in-java-without-executor-framework-ca10e61d
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class CustomThreadPoolExecutor {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numThreads) {
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i = 0;
        for (Thread t : workerThreads) {
            t = new Worker("Custom Pool Thread " + ++i);
            t.start();
        }
    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                try {
                    workerQueue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(10);
        IntStream.range(1,100).forEach(i->{
            threadPoolExecutor.addTask(() -> System.out.println(i+" print task"));
        });


    }

}