package javaPractice.practice;

import java.util.HashMap;
import java.util.Stack;

/**
 * http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
 * Created by Santosh on 5/18/17.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(isValid("{([])}"));
        System.out.println(isValid("{([]){"));

    }
}
