package javaPractice.sunPractice;

//Q: 2 Given
//        12. public class Yippee2 {
//    13.
//            14. static public void main(String [] yahoo) {
//        15. for(int x = 1; x < yahoo.length; x++) {
//            16. System.out.print(yahoo[x] + " ");
//            17. }
//        18. }
//    19. }
//    and the command line invocation:
//        java Yippee2 a b c
//        What is the result?
//        A. a b
//        B. b c
//        C. a b c
//        D. Compilation fails.
//        E. An exception is thrown at runtime.
//        Answer: B
//

public class Yippee2 {
    int u = 10;
    public static void main(String[] yahoo) {
        for (int x = 1; x < yahoo.length; x++) {
            System.out.print(yahoo[x] + " ");
        }
    }
}
