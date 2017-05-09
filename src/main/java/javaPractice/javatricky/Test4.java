package javaPractice.javatricky;


public class Test4 {
    public static void javaHugry(Exception e){
        System.out.println("Exception");
    }
    public static void javaHugry(ArithmeticException s){
        System.out.println("ArithmeticException");
    }
    public static void javaHugry(Object s){
        System.out.println("Object");
    }

    public static void main(String [] args){
        javaHugry(null);
    }
}
