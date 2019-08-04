package javaPractice.thread.defogexample.CompletableFutureExample;
/*
CompletableFuture.thenAccept
thenAccept method accepts Consumer as an argument.
On the completion of any completion stage, thenAccept method applies Consumer on the result
and returns CompletableFuture.
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFuture2Example {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Arrays.asList("A","B","C","D");
        list.stream().map(data->CompletableFuture.supplyAsync(()->"Processing:"+data)).
                map(compFuture->compFuture.thenAccept(s->System.out.println(s))).map(t->t.join())
                .count();
    }
}
/*
Processing:A
Processing:B
Processing:C
Processing:D
 */