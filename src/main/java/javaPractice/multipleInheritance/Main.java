package javaPractice.multipleInheritance;

//https://java2practice.com/2014/03/16/java-8-functional-interface-example/
interface Test{

    default void show(){
        System.out.println("show from Test");
    }

}

//Another interface with same show method

interface AnotherTest{

    default void show(){
        System.out.println("show from Test");
    }

}

public class Main implements Test, AnotherTest{
    @Override
    public void show(){
        System.out.println("Main show method");
    }

}
