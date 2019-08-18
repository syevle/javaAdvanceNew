package javaPractice.thread.defogexample.Future;

import java.util.concurrent.*;

/**
 * https://javarevisited.blogspot.com/2015/01/how-to-use-future-and-futuretask-in-Java.html
 * Java program to show how to use Future in Java. Future allows to write * asynchronous code in Java,
 * where Future promises result to be available in * future * * @author Javin
 */
public class FutureDemo {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(10);
        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);
        System.out.println("Task is submitted");
        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(1); //sleep for 1 millisecond before checking again
        }
        System.out.println("Task is completed, let's check result");
        long factorial = (Long)future.get();
        System.out.println("Factorial of 1000000 is : " + factorial);
        threadpool.shutdown();
    }

    private static class FactorialCalculator implements Callable {
        private final int number;

        public FactorialCalculator(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            long output = 0;
            try {
                output = factorial(number);
            } catch (InterruptedException ex) {
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
            return output;
        }

        private long factorial(int number) throws InterruptedException {
            if (number < 0) {
                throw new IllegalArgumentException("Number must be greater than zero");
            }
            long result = 1;
            while (number > 0) {
                Thread.sleep(1); // adding delay for example
                result = result * number;
                number--;
            }
            return result;
        }
    }
}
/*
Submitting Task ...
Task is submitted
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is not completed yet....
Task is completed, let's check result
Factorial of 1000000 is : 3628800
 */

