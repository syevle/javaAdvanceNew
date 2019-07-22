package javaPractice.javatricky;


public class Test3 {
    public static void javaHugry(String s){

        s = "i am javaHugry";
        System.out.println("Inside javaHugry "+s);
    }

    public static void main(String [] args){
        Test3 t = new Test3();
        String s = "I am new born";
        t.javaHugry(s);
        System.out.println(s);
    }
}
//=============== OutPut ========================
/*
    Inside javaHugry i am javaHugry
    I am new born

*/