package javaPractice.thread.defogexample.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciForkJoin extends RecursiveTask<Integer> {

    final int n;

    public FibonacciForkJoin(int n){
        this.n=n;
    }
    @Override
    protected Integer compute() {
        if (n<=1){
            return n;
        }else {
            FibonacciForkJoin f1 = new FibonacciForkJoin(n-1);
            f1.fork();
            FibonacciForkJoin f2 = new FibonacciForkJoin(n-2);
            f2.fork();
            return f2.join() + f1.join();
        }
    }
    public static void main(String sa[]){
        FibonacciForkJoin fibonacci = new FibonacciForkJoin(15);
        System.out.println(ForkJoinPool.commonPool().invoke(fibonacci).intValue());
    }


}
