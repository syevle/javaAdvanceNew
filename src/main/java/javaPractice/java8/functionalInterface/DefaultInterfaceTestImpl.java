package javaPractice.java8.functionalInterface;

interface DefaultInterfaceTest{
    void show();
    default void display(){
        System.out.println("Default method from interface can have body..!");
    }
}
public class DefaultInterfaceTestImpl implements DefaultInterfaceTest{
    public void show(){
        System.out.println("show method");
    }
    //we dont need to provide any implementation to default method.
    public static void main(String[] args){
        DefaultInterfaceTest obj = new DefaultInterfaceTestImpl();
        obj.show();//out puts: show method
        obj.display();//outputs : Default method from interface can have body..!
    }
}
