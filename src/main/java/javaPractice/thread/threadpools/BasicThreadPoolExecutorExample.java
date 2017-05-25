package javaPractice.thread.threadpools;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class Task implements Runnable
{
    private String name;

    public Task(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run()
    {
        try
        {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

public class BasicThreadPoolExecutorExample
{
    public static void main(String[] args)
    {
        //Use the executor created by the newCachedThreadPool() method
        //only when you have a reasonable number of threads
        //or when they have a short duration.
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
        }
        executor.shutdown();
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