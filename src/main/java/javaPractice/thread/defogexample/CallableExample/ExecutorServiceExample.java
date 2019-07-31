package javaPractice.thread.defogexample.CallableExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

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

        List<Future<Double>> results = new ArrayList<Future<Double>>();

        for (int i = 0; i < 20; i++) {
            Future<Double> result = execs.submit(new MyTask(i));
            results.add(result);
        }

        // this is just a signal; it won't terminate until all tasks are completed
        execs.shutdown();
        System.out.println("Sent shutdown signal");

        execs.awaitTermination(60, TimeUnit.MINUTES);

        System.out.println("Results: ");
        int index = 0;
        for (Future<Double> result : results) {
            System.out.println(index++ + ":\t" + result.get());
        }
    }
}

/*
Output

Working on index 0...
Working on index 4...
Working on index 3...
Working on index 2...
Working on index 1...
Sent shutdown signal
Completed index 4
Completed index 0
Completed index 1
Completed index 3
Completed index 2
Working on index 5...
Working on index 7...
Working on index 8...
Working on index 6...
Working on index 9...
Completed index 5
Completed index 8
Completed index 6
Completed index 9
Completed index 7
Working on index 13...
Working on index 12...
Working on index 11...
Working on index 10...
Working on index 14...
Completed index 12
Completed index 14
Completed index 13
Completed index 11
Completed index 10
Working on index 18...
Working on index 17...
Working on index 16...
Working on index 15...
Working on index 19...
Completed index 18
Completed index 19
Completed index 17
Completed index 16
Completed index 15
Results:
0:	0.0
1:	0.001
2:	0.002
3:	0.003
4:	0.004
5:	0.005
6:	0.006
7:	0.007
8:	0.008
9:	0.009000000000000001
10:	0.01
11:	0.011
12:	0.012
13:	0.013000000000000001
14:	0.014
15:	0.015
16:	0.016
17:	0.017
18:	0.018000000000000002
19:	0.019

Process finished with exit code 0

 */