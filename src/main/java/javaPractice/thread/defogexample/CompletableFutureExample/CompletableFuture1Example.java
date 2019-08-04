package javaPractice.thread.defogexample.CompletableFutureExample;
/*
CompletableFuture.join
join method returns the result after completion or throws CompletionException.
This method waits for the completion of calling completion stage.
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFuture1Example {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().map(data->CompletableFuture.supplyAsync(()->getNumber(data))).
                map(compFuture->compFuture.thenApply(n->n+n)).map(t->t.join())
                .forEach(s->System.out.println(s));
    }
    private static int getNumber(int a){
        return a;
    }
}
