package javaPractice.thread.defogexample.CallableExample;

import java.util.concurrent.*;
//Link : https://nirajsonawane.github.io/2018/06/17/Callable-and-Future/
class CallableWorkerExample implements Callable<String>
{
    private String someReturnValue;
    public CallableWorkerExample(String someValue) {
        this.someReturnValue=someValue;
    }
    @Override
    public String call() throws Exception {

        System.out.println("Working on call");
        Thread.sleep(3000);
        return this.someReturnValue;
    }
}
public class CallableAndFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableWorkerExample worker= new CallableWorkerExample("Some Value");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<String> submit = newSingleThreadExecutor.submit(worker);
        System.out.println("Task Submited");
        String returnValue = submit.get();
        System.out.println("Return value from Callable " +returnValue);
    }
}

/*
Task Submited
Working on call
Return value from Callable Some Value
 */