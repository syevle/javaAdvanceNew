package javaPractice.thread.ParallelTasks;


import javaPractice.thread.ConcurrentUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Main{
    public static void main(String args[]){
        List<Integer> data = new ArrayList<>();

        IntStream.range(1,20).forEach(i->data.add(i));

        //creates as many threads as there are processors
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processor size is : "+processors);
        int portion = data.size() / processors;

//        List<MyTask> threads = new ArrayList<MyTask>();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < processors; ++i){
            int from = i*portion;
            int to = i < processors-1 ? (i+1)*portion : data.size();
            MyTask task = new MyTask(data.subList(from, to));
//            threads.add(task);
            executor.submit(task);
        }

        ConcurrentUtils.stop(executor);

        //start the threads
//        for (MyTask t : threads){
//            t.start();
//        }
//        for (MyTask t : threads){
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

class MyTask extends Thread{
    private List<Integer> data;

    public MyTask(List<Integer> data){
        this.data = data;
    }

    public void run(){
//        for (Integer d : data){
//            System.out.println("Job run start : "+d);
//            function1(d);
//            function2(d);
//            System.out.println("Job run end : "+d);
//        }
        data.forEach(d->{
            System.out.println("Job run start : "+d);
            function1(d);
            function2(d);
            System.out.println("Job run end : "+d);
        });
    }

    private void function1(Integer i){
        System.out.println("function1 for : "+i);
    }
    private void function2(Integer i){
        System.out.println("function2 for : "+i);
    }
}

/*
processor size is : 8
Job run start : 9
Job run start : 7
function1 for : 7
Job run start : 1
function1 for : 1
function2 for : 1
Job run start : 5
function1 for : 5
function2 for : 5
Job run end : 5
Job run start : 6
function1 for : 6
Job run start : 3
Job run start : 11
function1 for : 11
function1 for : 3
function2 for : 3
Job run end : 3
Job run start : 4
function1 for : 4
function2 for : 4
Job run end : 4
function2 for : 6
Job run end : 6
Job run start : 13
function1 for : 13
function2 for : 13
Job run end : 13
Job run start : 14
function1 for : 14
function2 for : 14
Job run end : 14
Job run start : 15
function1 for : 15
function2 for : 15
Job run end : 15
Job run end : 1
Job run start : 2
function1 for : 2
function2 for : 2
Job run end : 2
function2 for : 7
Job run end : 7
Job run start : 8
function1 for : 8
function2 for : 8
Job run end : 8
function1 for : 9
Job run start : 16
function1 for : 16
function2 for : 16
Job run end : 16
Job run start : 17
function1 for : 17
function2 for : 17
Job run end : 17
Job run start : 18
function1 for : 18
function2 for : 18
Job run end : 18
function2 for : 11
Job run end : 11
Job run start : 19
function1 for : 19
function2 for : 19
Job run end : 19
function2 for : 9
Job run end : 9
Job run start : 10
function1 for : 10
Job run start : 12
function1 for : 12
function2 for : 12
Job run end : 12
function2 for : 10
Job run end : 10

 */