package javaPractice.sunPractice;

public class Threads4 {
    public static void main (String[] args) {
        new Threads4().go();
    }
    public void go() {
        Runnable r = new Runnable() {
            public void run() {
                System.out.print("foo");
            }
        };
        Thread t = new Thread(r);
        t.start();
        t.start();
    }
}

/*
Exception in thread "main" java.lang.IllegalThreadStateException
foo	at java.lang.Thread.start(Thread.java:705)
	at javaPractice.sunPractice.Threads4.go(Threads4.java:15)
	at javaPractice.sunPractice.Threads4.main(Threads4.java:5)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
 */