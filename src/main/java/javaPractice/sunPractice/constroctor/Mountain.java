package javaPractice.sunPractice.constroctor;

/**
 * QUESTION 14
 Given:
 1. class Atom {
 2. Atom() { System.out.print("atom "); }
 3. }
 4. class Rock extends Atom {
 5. Rock(String type) { System.out.print(type); }
 6. }
 7. public class Mountain extends Rock {
 8. Mountain() {
 9. super("granite ");
 10. new Rock("granite ");
 11. }
 12. public static void main(String[] a) { new Mountain(); }
 13.}
 What is the result?
 A. Compilation fails.
 B. atom granite
 C. granite granite
 D. atom granite granite
 E. An exception is thrown at runtime.
 F. atom granite atom granite
 Correct Answer: F
 Section: All
 Explanation
 Explanation/Reference:
 QUESTION 15
 */
class Atom {
    Atom() { System.out.print("atom "); }
}
class Rock extends Atom {
    Rock(String type) { System.out.print(type); }
}
public class Mountain extends Rock {
    Mountain() {
        super("granite ");
        new Rock("granite ");
    }
    public static void main(String[] a) { new Mountain(); }
}
