package javaPractice.sunPractice;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Santosh on 6/9/17.
 */

interface A { public void aMethod(); }
interface B { public void bMethod(); }
interface C extends A,B { public void cMethod(); }
class D implements B {
    public void bMethod(){}
    }
class E extends D implements C {
    public void aMethod(){}
    public void bMethod(){}
    public void cMethod(){}
    }

public class Test {
    public static void main(String[] args) {

    }
}
