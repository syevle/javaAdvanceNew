package javaPractice.thread.low_level_producer_consumer;

import javaPractice.thread.ConcurrentUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        final Processor processor = new Processor();

//        Thread t1 = new Thread(new Runnable() {
//
//            public void run() {
//                try {
//                    processor.produce();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        Thread t2 = new Thread(new Runnable() {
//
//            public void run() {
//                try {
//                    processor.consume();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });



        Runnable r1 = ()-> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        Runnable r2 = ()-> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        executor.submit(r1);
        executor.submit(r2);


        ConcurrentUtils.stop(executor);


//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
    }
}

/*
/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/bin/java -Didea.launcher.port=7551 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 15.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/lib/tools.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Users/Santosh/java8/master/javaAdvanceNew/target/classes:/Users/Santosh/.m2/repository/joda-time/joda-time/2.3/joda-time-2.3.jar:/Users/Santosh/.m2/repository/org/springframework/spring-core/4.1.0.RELEASE/spring-core-4.1.0.RELEASE.jar:/Users/Santosh/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar:/Users/Santosh/.m2/repository/org/springframework/spring-context/4.1.0.RELEASE/spring-context-4.1.0.RELEASE.jar:/Users/Santosh/.m2/repository/org/springframework/spring-aop/4.1.0.RELEASE/spring-aop-4.1.0.RELEASE.jar:/Users/Santosh/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/Users/Santosh/.m2/repository/org/springframework/spring-beans/4.1.0.RELEASE/spring-beans-4.1.0.RELEASE.jar:/Users/Santosh/.m2/repository/org/springframework/spring-expression/4.1.0.RELEASE/spring-expression-4.1.0.RELEASE.jar:/Applications/IntelliJ IDEA 15.app/Contents/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain javaPractice.thread.low_level_producer_consumer.App
producer add value in List 1 List size is: 1
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 2 List size is: 2
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 3 List size is: 3
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 4 List size is: 4
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 5 List size is: 5
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 6 List size is: 6
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 7 List size is: 7
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 8 List size is: 8
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 9 List size is: 9
producer :: lock.notify() before
producer :: lock.notify() after
producer add value in List 10 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consume :: List size is: 10
; value is: 1consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 11 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 2consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 12 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 3consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 13 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 4consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 14 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 5consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 15 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 6consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 16 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 7consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 17 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 8consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 18 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 9consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 19 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 10consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 20 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 11consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 21 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start
consumer :: Thread.sleep(random.nextInt(1000)) end
consume :: List size is: 10
; value is: 12consumer :: lock.notify() before
consumer :: lock.notify() after
consumer :: Thread.sleep(random.nextInt(1000)) start
produce :: lock.wait() call end
producer add value in List 22 List size is: 10
producer :: lock.notify() before
producer :: lock.notify() after
produce :: lock.wait() call start

Process finished with exit code 130

 */
