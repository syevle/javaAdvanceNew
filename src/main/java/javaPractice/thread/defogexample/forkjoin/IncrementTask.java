package javaPractice.thread.defogexample.forkjoin;

/*
Link : https://www.javacodemonk.com/how-will-you-increment-each-element-of-an-integer-array-using-parallel-operation-2726ada4
 */
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class IncrementTask extends RecursiveAction {
    private final int THRESHOLD = 100;
    final long[] array;
    final int lo, hi;

    IncrementTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    protected void compute() {
        if (hi - lo < THRESHOLD) {
            for (int i = lo; i < hi; ++i)
                array[i]++;
        } else {
            int mid = (lo + hi) >>> 1;
            invokeAll(new IncrementTask(array, lo, mid), new IncrementTask(array, mid, hi));
        }
    }

    public static void main(String[] args) {
        long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IncrementTask incrementTask = new IncrementTask(array, 0, 9);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(incrementTask);
        System.out.println("array = " + Arrays.toString(array));
    }
}
