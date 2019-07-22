package javaPractice.javatricky;

/*
The reason for this is that
the Java compiler parses the unicode character \u000d as a new line and gets transformed into:

 */

class Test7 {

    public static void main(String args[]){
        // the line below this gives an output
        // \u000d System.out.println("comment executed");

    }
}
