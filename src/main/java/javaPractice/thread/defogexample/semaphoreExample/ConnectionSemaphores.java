package javaPractice.thread.defogexample.semaphoreExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
// Link : https://nirajsonawane.github.io/2018/06/15/Semaphores/
class ConnectionPool {

    private Semaphore connectionSemaphore;

    public ConnectionPool(int poolsize) {
        this.connectionSemaphore = new Semaphore(poolsize);
    }

    public void getConnectionFromPool() {
        if (connectionSemaphore.availablePermits() > 0) {
            connectionSemaphore.tryAcquire();
            System.out.println("Get the connection");
        } else {
            System.out.println("Max active connection limit reach!! try again");
        }
    }
    public void releaseConnection()
    {
        connectionSemaphore.release();
    }
}
class ConnectionService implements Runnable {

    private ConnectionPool connectionPool;
    public ConnectionService(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        connectionPool.getConnectionFromPool();
    }
}
public class ConnectionSemaphores {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ConnectionPool connectionPool = new ConnectionPool(5);
        ConnectionService service = new ConnectionService(connectionPool);
        IntStream.range(0, 10)
                .forEach((cnt) -> executorService.execute(service));
    }
}
/*
Get the connection
Get the connection
Get the connection
Get the connection
Get the connection
Max active connection limit reach!! try again
Max active connection limit reach!! try again
Max active connection limit reach!! try again
Max active connection limit reach!! try again
Max active connection limit reach!! try again
 */