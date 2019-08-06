package javaPractice.thread.defogexample.CallableExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample2 {

    private static class MyTask implements Callable<Double> {

        private final int index;

        private MyTask(Integer idx) { index = idx; }

        public Double call() throws InterruptedException {
            System.out.println("Working on index " + index + "...");

            // pretend we're doing something long and complex here...
            Thread.sleep(2000);

            System.out.println("Completed index " + index);

            // pretend this is the net result of the long, complex thing we did:
            return index * .001;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService execs = Executors.newFixedThreadPool(5);
        Future<Double> result = execs.submit(new MyTask(10));
        // this is just a signal; it won't terminate until all tasks are completed
        execs.shutdown();
        System.out.println("Sent shutdown signal");
        execs.awaitTermination(60, TimeUnit.MINUTES);

        System.out.println("Results: ");
        System.out.println(result.get());
    }
}

/*
Output
Working on index 10...
Sent shutdown signal
Completed index 10
Results:
0.01

 */