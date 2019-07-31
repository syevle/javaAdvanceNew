package javaPractice.thread.defogexample.CustomThreadExample;

/**
 *How to use the ReentrantLock class in Java as an alternative to synchronized code blocks.
 *ReentrantLocks let you do all the stuff that you can do with synchronized, wait and notify, plus
 *some more stuff besides that may come in handy from time to time.
 */

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    // total 10 connection pool object made.
    private Semaphore sem = new Semaphore(10, true);

    private int connections = 0;

    private Connection() {
    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException {
        sem.acquireUninterruptibly();
        try {
            doConnect();
        } finally {
            sem.release();
        }
    }

    public void doConnect() throws InterruptedException {
        synchronized (this) {
            connections++;
            System.out.println("Get connections: " + connections);
        }
        // DB Work done in 2 second.
        Thread.sleep(2000);
        // DB work done and release DB connection.
        synchronized (this) {
            connections--;
            System.out.println("Release connections: " + connections);
        }

    }
}
