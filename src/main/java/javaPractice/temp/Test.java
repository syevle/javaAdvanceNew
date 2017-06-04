package javaPractice.temp;


import javaPractice.java8.venkat.m07_reduction_collect.Collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String sa[]){


            List<String> collection = new ArrayList<String>();

            collection.add("zero");
            collection.add("one");
            collection.add("two");

        List l1 = Collections.unmodifiableList(collection);


        l1.remove(0);
        Iterator<String> iterator = l1.iterator();
            // while loop
            while (iterator.hasNext()) {
                System.out.println("value= " + iterator.next());
            }



//        while (iterator.hasNext()) {
//            System.out.println("value= " + iterator.next());
//        }

        }


}
