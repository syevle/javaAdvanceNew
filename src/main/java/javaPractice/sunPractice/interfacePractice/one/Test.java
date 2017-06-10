package javaPractice.sunPractice.interfacePractice.one;

/**
 * Created by Santosh on 6/6/17.
 */

interface A {
    public void doSomething(String thing);
}
class AImpl implements A {
    public void doSomething(String msg) {}
}
class B {
    public A doit(){
        //more code here
        return null;
    }
    public String execute(){
        //more code here
        return null;
    }
}
class C extends B {
    public AImpl doit(){
        //more code here
        return null;
    }

//    public Object execute() {
//        //more code here
//        return null;
//    }

    public String execute() {
        //more code here
        return null;
    }
}


public class Test {


}
