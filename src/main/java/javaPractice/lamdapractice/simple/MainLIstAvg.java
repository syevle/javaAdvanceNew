package javaPractice.lamdapractice.simple;

import java.util.ArrayList;
import java.util.List;

public class MainLIstAvg {
    /*w  w  w. ja  va  2  s .  com*/
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);

        MyListAvg myListAvg = (List<Integer> marks) -> {
            int sum = 0;
            for (int i=0; i< marks.size(); i++) {
                sum += marks.get(i);
            }
            return sum / marks.size();
        };
        System.out.println("1- Avrage x2 : " + myListAvg.avgIt(l1));

    }
}

interface MyListAvg {
    public Integer avgIt(List<Integer> list);
}