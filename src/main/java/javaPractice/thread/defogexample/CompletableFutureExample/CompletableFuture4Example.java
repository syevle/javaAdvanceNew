package javaPractice.thread.defogexample.CompletableFutureExample;

/*
CompletableFuture.whenComplete
whenComplete method uses BiConsumer as an argument.
Once the calling completion stage completes,
whenComplete method applies completion stage result on BiConsumer.
BiConsumer takes first argument as result and second argument as error if any.
 */
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFuture4Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D");
        list.stream().map(s->CompletableFuture.supplyAsync(()->s+s))
                .map(f->f.whenComplete((result,error)->System.out.println(result+" Error:"+error))).count();
    }
}
/*
---First time output
AA Error:null
BB Error:null
CC Error:null
DD Error:null

-----second time output
BB Error:null
CC Error:null
DD Error:null

--- Third time output
BB Error:null
CC Error:null
DD Error:null
AA Error:null
 */