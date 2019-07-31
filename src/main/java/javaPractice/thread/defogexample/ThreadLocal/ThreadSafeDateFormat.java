package javaPractice.thread.defogexample.ThreadLocal;

/*
https://www.javacodemonk.com/what-is-threadlocal-in-java-where-will-you-use-this-class-3912002e
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeDateFormat {
    //SimpleDateFormat is not thread-safe, so give one instance to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy.MM.dd HHmm a"));

    public static String formatIt(Date date) {
        return formatter.get().format(date);
    }

    public static void main(String[] args) {
        final String formatIt = ThreadSafeDateFormat.formatIt(new Date());
        System.out.println("formatIt = " + formatIt);
    }
}
