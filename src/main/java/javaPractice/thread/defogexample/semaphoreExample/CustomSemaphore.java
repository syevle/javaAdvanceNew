package javaPractice.thread.defogexample.semaphoreExample;

/*
https://www.javacodemonk.com/how-will-you-implement-your-custom-threadsafe-semaphore-in-java-047e4890
 */

//import javax.annotation.concurrent.GuardedBy;
//import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@ThreadSafe
public class CustomSemaphore {
    private final Lock lock = new ReentrantLock();
    // CONDITION PREDICATE: permitsAvailable (permits > 0)
    private final Condition permitsAvailable = lock.newCondition();

//    @GuardedBy("lock")
    private int permits;

    CustomSemaphore(int initialPermits) {
        lock.lock();
        try {
            permits = initialPermits;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Blocks until permitsAvailable (permit > 0)
     * @throws InterruptedException
     */
    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0)
                permitsAvailable.await();
            --permits;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Release a single permit and notifies threads waiting on permitsAvailable Condition
     */
    public void release() {
        lock.lock();
        try {
            ++permits;
            permitsAvailable.signal();
        } finally {
            lock.unlock();
        }
    }

}