package javaPractice.sunPractice.innnerClass;

/**
 * Q: 02 Given the command line java Pass2 and:
 15. public class Pass2 {
 16. public void main(String [] args) {
 17. int x = 6;
 18. Pass2 p = new Pass2();
 19. p.doStuff(x);
 20. System.out.print(" main x = " + x);
 21. }
 22.
 23. void doStuff(int x) {
 24. System.out.print(" doStuff x = " + x++);
 25. }
 26. }
 What is the result?
 A. Compilation fails.
 B. An exception is thrown at runtime.
 C. doStuff x = 6 main x = 6
 D. doStuff x = 6 main x = 7
 E. doStuff x = 7 main x = 6
 F. doStuff x = 7 main x = 7
 Answer: B
 */
public class Pass2 {
    public static void main(String [] args) {
        int x = 6;
        Pass2 p = new Pass2();
        p.doStuff(x);
        System.out.print(" main x = " + x);
    }

    void doStuff(int x) {
        System.out.print("int doStuff x = " + x++);
//        System.out.print(" doStuff x = " + ++x);
    }
    void doStuff(Integer x) {
        System.out.print("Integer doStuff x = " + x++);
//        System.out.print(" doStuff x = " + ++x);
    }
}

/*
Output :
int doStuff x = 6 main x = 6
 */
