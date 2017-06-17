package javaPractice.thread.ParallelTasks;

import java.util.ArrayList;
import java.util.List;

class Main{
    public static void main(String args[]){
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(6);
        data.add(7);
        data.add(8);
        data.add(9);
        data.add(9);
        data.add(10);
        data.add(11);
        data.add(12);
        data.add(13);
        data.add(14);
        data.add(15);
        data.add(16);
        data.add(17);
        data.add(18);
        data.add(19);
        data.add(20);


        //creates as many threads as there are processors
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processor size is : "+processors);
        int portion = data.size() / processors;

        List<MyTask> threads = new ArrayList<MyTask>();

        for (int i = 0; i < processors; ++i){
            int from = i*portion;
            int to = i < processors-1 ? (i+1)*portion : data.size();
            MyTask task = new MyTask(data.subList(from, to));
            threads.add(task);
        }

        //start the threads
        for (MyTask t : threads){
            t.start();
        }
        for (MyTask t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyTask extends Thread{
    private List<Integer> data;

    public MyTask(List<Integer> data){
        this.data = data;
    }

    public void run(){
        for (Integer d : data){
            System.out.println("Job run start : "+d);
            function1(d);
            function2(d);
            System.out.println("Job run end : "+d);
        }
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
Job run start : 1
Job run start : 3
function1 for : 3
Job run start : 7
Job run start : 12
function1 for : 12
function2 for : 12
Job run start : 5
function1 for : 5
function2 for : 5
Job run end : 5
Job run start : 6
function1 for : 6
Job run start : 14
function1 for : 14
function2 for : 14
Job run end : 14
Job run end : 12
Job run start : 13
function1 for : 13
function2 for : 13
Job run end : 13
function1 for : 7
function2 for : 7
Job run end : 7
function2 for : 3
Job run end : 3
Job run start : 4
function1 for : 4
function2 for : 4
Job run end : 4
Job run start : 10
function1 for : 10
Job run start : 9
function1 for : 9
function2 for : 9
Job run end : 9
Job run start : 9
function1 for : 9
function2 for : 9
Job run end : 9
function1 for : 1
function2 for : 1
Job run end : 1
Job run start : 2
function1 for : 2
function2 for : 2
Job run end : 2
function2 for : 10
Job run end : 10
Job run start : 8
Job run start : 15
function1 for : 15
function2 for : 15
Job run end : 15
function2 for : 6
Job run start : 16
function1 for : 16
function2 for : 16
Job run end : 16
function1 for : 8
function2 for : 8
Job run end : 8
Job run start : 11
function1 for : 11
function2 for : 11
Job run end : 11
Job run end : 6

 */