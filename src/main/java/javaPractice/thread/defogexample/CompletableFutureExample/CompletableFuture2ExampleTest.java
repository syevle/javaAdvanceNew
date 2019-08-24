package javaPractice.thread.defogexample.CompletableFutureExample;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CompletableFuture2ExampleTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Function<Integer,Integer> display = x -> {
//            return x;
//        };
//        CompletableFuture<Void> completableFuture
//                = CompletableFuture.supplyAsync(() -> getNumber(1))
//                .thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + getNumber(4)))
//                .exceptionally(cause->{System.out.println(cause); return null;})
//                .thenApplyAsync(display)
//                .thenAcceptAsync(System.out::println);

        CompletableFuture<Void> completableFuture
                = CompletableFuture.supplyAsync(() -> getNumber(1))
                .thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> s + getNumber(4)))
                .exceptionally(cause->{System.out.println(cause); return null;})
                .thenAcceptAsync(System.out::println);


//        CompletableFuture<Void> completableFuture
//                = CompletableFuture.supplyAsync(() -> getNumber(1))
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + getNumber(4)))
//                .thenAccept(s->System.out.println(s));

        System.out.println("Test");
        Thread.sleep(30000);

    }

    private static int getNumber(int a){
        try {
            Thread.sleep(500);
//            throw new NullPointerException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }
}
