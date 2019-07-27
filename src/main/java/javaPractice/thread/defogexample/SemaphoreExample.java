package javaPractice.thread.defogexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Task implements Runnable
{
    private String name;
    private Semaphore semaphore;

    public Task(String name,Semaphore semaphore)
    {
        this.name = name;
        this.semaphore = semaphore;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run()
    {
        semaphore.acquireUninterruptibly();
        longRunningIOcall();
        semaphore.release();
    }

    private void longRunningIOcall() {
        try {
            //Long Running IO call
            System.out.println("Start long running IO call "+name);
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreExample
{
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService service =  Executors.newFixedThreadPool(50);
        //Due to semaphore at time only 3 thread execute and other thread blocking state.
        IntStream.range(0,1000).forEach(i->service.execute(new Task("Task "+i,semaphore)));
        service.shutdown();
        service.awaitTermination(1,TimeUnit.MINUTES);

    }
}


/*
Output:

A new task has been added : Task 0
A new task has been added : Task 1
A new task has been added : Task 2
A new task has been added : Task 3
A new task has been added : Task 4
A new task has been added : Task 5
Doing a task during : Task 5
Doing a task during : Task 0
Doing a task during : Task 2
Doing a task during : Task 1
Doing a task during : Task 4
Doing a task during : Task 3
 */