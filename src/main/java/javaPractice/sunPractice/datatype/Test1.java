package javaPractice.sunPractice.datatype;

/**
 * Created by Santosh on 6/18/17.
 */
public class Test1 {
    public static void printValue(int i, int j, int k){
        System.out.println("int");
    }
    public static void printValue(byte...b){
        System.out.println("byte");
    }
    public static void main(String... args) {
        byte b = 9;
//        short b = 9;
        printValue(b,b,b);
    }
}

/*
Options are
A.long
B.int
C.Compilation fails
D.Compilation clean but throws RuntimeException
Answer :
B is the correct answer.
Primitive widening uses the smallest method argument possible. (For Example if you
pass short value to a method but method with short argument is not available then
compiler choose method with int argument). But in this case compiler will prefer the
older style before it chooses the newer style, to keep existing code more robust. var-args
method is looser than widen.
 */
