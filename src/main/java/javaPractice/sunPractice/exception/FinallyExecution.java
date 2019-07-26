package javaPractice.sunPractice.exception;

public class FinallyExecution {
    public static void main(String[] args) {
        try{
            FinallyExecution.divide(100, 0);}
        finally{
            System.out.println("finally in main");
        }
    }
    public static void divide(int n, int div){
        try{
            int ans = n/div; }
        finally{
            System.out.println("finally of divide");
        }
    }
}

/*
finally of divide
finally in main
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at javaPractice.sunPractice.exception.FinallyExecution.divide(FinallyExecution.java:13)
	at javaPractice.sunPractice.exception.FinallyExecution.main(FinallyExecution.java:6)

 */