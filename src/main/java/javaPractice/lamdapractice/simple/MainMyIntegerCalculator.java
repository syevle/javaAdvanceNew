package javaPractice.lamdapractice.simple;

public class MainMyIntegerCalculator {
    /*w  w  w. ja  va  2  s .  com*/
    public static void main(String[] args) {
        MyIntegerCalculator myIntegerCalculator = (Integer s1) -> s1 * 2;

        System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));

    }
}
interface MyIntegerCalculator {

    public Integer calcIt(Integer s1);

}