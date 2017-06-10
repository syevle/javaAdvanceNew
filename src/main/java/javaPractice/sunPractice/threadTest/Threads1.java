package javaPractice.sunPractice.threadTest;

/**
 * Created by Santosh on 6/9/17.
 */
public class Threads1 {
    int x = 0;

    public static void main(String[] args) {
        new Threads1().go();
    }

    public void go() {
        Runnable r1 = new Runner();
        new Thread(r1).start();
        new Thread(r1).start();
    }

    public class Runner implements Runnable {
        public void run() {
            int current = 0;
            for (int i = 0; i < 4; i++) {
                current = x;
                System.out.println(current + ", ");
                x = current + 2;
            }
        }
    }
}