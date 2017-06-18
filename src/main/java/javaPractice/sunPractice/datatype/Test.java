package javaPractice.sunPractice.datatype;

/**
 * Created by Santosh on 6/18/17.
 */
public class Test {
    public static void main(String[] args) {
        byte b = 6;
        b += 8;
        System.out.println(b);
//        b = b + 7;
        System.out.println(b);
    }
}

/*
A.14 21
B.14 13
C.Compilation fails with an error at line 6
D.Compilation fails with an error at line 4
Answer :
C is the correct answer.
int or smaller expressions always resulting in an int. So compiler complain about Type
mismatch: cannot convert from int to byte for b = b+7; But b += 7; // No problem
because +=, -=, *=, and /= will all put in an implicit cast. b += 7 is same as b = (byte)b+7
so compiler not complain.
 */