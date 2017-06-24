package javaPractice.java8.venkat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution {

    static int[] solve(int[] grades){
        List<Integer> gradeList = Arrays.stream(grades).boxed().collect(Collectors.toList());
        //return gradeList.stream().filter(i->i>=40).map(Solution::getRoundedGrade).mapToInt(Integer::intValue).toArray();
        return gradeList.stream().map(Solution::getRoundedGrade).mapToInt(Integer::intValue).toArray();
    }
    public static Integer getRoundedGrade(Integer grade) {
        if (grade >= 40) {
            int mod5 = grade % 5;
            if (mod5 > 3) {
                grade += 5 - mod5;
            }
        }

        return grade;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }
}
