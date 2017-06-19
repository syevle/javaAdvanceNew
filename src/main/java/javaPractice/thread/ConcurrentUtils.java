package javaPractice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Benjamin Winterberg
 */
public class ConcurrentUtils {

    public static void stop(ExecutorService executor) {
        try {
            //executor does not accept any more tasks but the submitted tasks continue
            executor.shutdown();
            //wait for the exectutor to terminate normally, which will return true
            //if timeout happens, returns false, but this does NOT interrupt the threads
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            //this will interrupt thread it manages. catch the interrupted exception in the threads
            //If not, threads will run forever and executor will never be able to shutdown.
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
