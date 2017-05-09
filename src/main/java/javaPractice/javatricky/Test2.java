package javaPractice.javatricky;


public class Test2 {
    public static void javaHugry(String s){
        System.out.println("String");
    }
    public static void javaHugry(Object s){
        System.out.println("Object");
    }

    public static void main(String [] args){
        javaHugry(null);
    }
}
