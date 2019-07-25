package javaPractice.sunPractice.staticTest;

/**
 * Created by Santosh on 6/9/17.
 */
public class Base {
    public static final String FOO = "foo";
}
class Sub extends Base {
    public static final String FOO = "bar";
    public static void main(String[] args) {
        Base b = new Base();
        Sub s = new Sub();
        System.out.println(Base.FOO);
        System.out.println(Sub.FOO);
        System.out.println(b.FOO);
        System.out.println(s.FOO);
        System.out.print(((Base) s).FOO);
    }
}

/*
foo
bar
foo
bar
foo
 */