package javaPractice.thread.defogexample.CompletableFutureExample;
/*
CompletableFuture.getNow
getNow is a method that if calling completion stage is not completed
then the value passed to getNow will be set to result.
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFutureFourExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D");
        list.stream().map(s->CompletableFuture.supplyAsync(()->s+s))
                .map(f->f.getNow("Not Done")).forEach(s->System.out.println(s));
    }
}
/*
---- First time output ----
Not Done
BB
Not Done
Not Done

----------second time output
Not Done
Not Done
Not Done
Not Done


 */