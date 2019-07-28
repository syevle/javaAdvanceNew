package javaPractice.thread.defogexample.forkjoin;

public class Fibonacci {
    public int fib(int n){
        if (n<=1){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main(String sa[]){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(9));
    }
}
