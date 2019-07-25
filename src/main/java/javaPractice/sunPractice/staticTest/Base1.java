package javaPractice.sunPractice.staticTest;

/**
 * Created by Santosh on 6/9/17.
 */
public class Base1 {
    public String FOO = "foo";
}

class Sub1 extends Base1 {
    public String FOO = "bar";
    public static void main(String[] args) {
        Base1 b = new Base1();
        Sub1 s = new Sub1();
//        System.out.println(Base1.FOO);
//        System.out.println(Sub1.FOO);
        System.out.println(b.FOO);
        System.out.println(s.FOO);
        System.out.print(((Base1) s).FOO);
    }
}

/*
foo
bar
foo
bar
foo
 */