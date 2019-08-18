package javaPractice.thread.defogexample.CyclicBarrierExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
https://codepumpkin.com/cyclicbarrier-java-concurrency-utilities/
 */
public class CyclicBarrierDemo {

    public static void main(String args[])
    {

        // creating CyclicBarrier (checkPoint) with
        // 4 parties (Bikers) threads that need to call await()
        final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all biker threads will reach barrier
                System.out.println("\nAll bikers have arrived to checkpoint. Lets refill the petrol\n");
            }
        });

        //starting each of thread
        Thread biker1 = new Thread(new Biker(checkPoint), "Biker Thread 1");
        Thread biker2 = new Thread(new Biker(checkPoint), "Biker Thread 2");
        Thread biker3 = new Thread(new Biker(checkPoint), "Biker Thread 3");
        Thread biker4 = new Thread(new Biker(checkPoint), "Biker Thread 4");

        biker1.start();
        biker2.start();
        biker3.start();
        biker4.start();


    }
}


class Biker implements Runnable
{

    private CyclicBarrier checkPoint;

    public Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
    }


    @Override
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " has left Manali");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");

            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has reached Leh");

        }
        catch (InterruptedException |  BrokenBarrierException ex)
        {
            ex.printStackTrace();
        }
    }


    /*
    /usr/lib/jvm/java-8-oracle/bin/java -javaagent:/snap/intellij-idea-community/163/lib/idea_rt.jar=41695:/snap/intellij-idea-community/163/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-oracle/jre/lib/charsets.jar:/usr/lib/jvm/java-8-oracle/jre/lib/deploy.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-oracle/jre/lib/javaws.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jce.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfr.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jsse.jar:/usr/lib/jvm/java-8-oracle/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-oracle/jre/lib/plugin.jar:/usr/lib/jvm/java-8-oracle/jre/lib/resources.jar:/usr/lib/jvm/java-8-oracle/jre/lib/rt.jar:/home/santosh/javascal/java/javaAdvanceNew/target/classes:/home/santosh/.m2/repository/org/projectlombok/lombok/1.18.4/lombok-1.18.4.jar:/home/santosh/.m2/repository/joda-time/joda-time/2.3/joda-time-2.3.jar:/home/santosh/.m2/repository/org/springframework/spring-core/4.1.0.RELEASE/spring-core-4.1.0.RELEASE.jar:/home/santosh/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar:/home/santosh/.m2/repository/org/springframework/spring-context/4.1.0.RELEASE/spring-context-4.1.0.RELEASE.jar:/home/santosh/.m2/repository/org/springframework/spring-aop/4.1.0.RELEASE/spring-aop-4.1.0.RELEASE.jar:/home/santosh/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/home/santosh/.m2/repository/org/springframework/spring-beans/4.1.0.RELEASE/spring-beans-4.1.0.RELEASE.jar:/home/santosh/.m2/repository/org/springframework/spring-expression/4.1.0.RELEASE/spring-expression-4.1.0.RELEASE.jar javaPractice.thread.defogexample.CyclicBarrierExample.CyclicBarrierDemo
Biker Thread 1 has left Manali
Biker Thread 2 has left Manali
Biker Thread 3 has left Manali
Biker Thread 4 has left Manali

All bikers have arrived to checkpoint. Lets refill the petrol

Biker Thread 4 has left the first checkpoint / barrier
Biker Thread 1 has left the first checkpoint / barrier
Biker Thread 2 has left the first checkpoint / barrier
Biker Thread 3 has left the first checkpoint / barrier

All bikers have arrived to checkpoint. Lets refill the petrol

Biker Thread 3 has left the second checkpoint / barrier
Biker Thread 2 has left the second checkpoint / barrier
Biker Thread 4 has left the second checkpoint / barrier
Biker Thread 1 has left the second checkpoint / barrier

All bikers have arrived to checkpoint. Lets refill the petrol

Biker Thread 2 has reached Leh
Biker Thread 1 has reached Leh
Biker Thread 4 has reached Leh
Biker Thread 3 has reached Leh

Process finished with exit code 0

     */
}