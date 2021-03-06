package javaPractice.practice;

import java.util.HashMap;

/**
 * http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 *
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s can be replaced to get t.

 For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.

 Analysis

 We can define a map which tracks the char-char mappings. If a value is already mapped, it can not be mapped again.


 */
public class Isomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if(s==null||t==null)
            return false;

        if(s.length()!=t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();


        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)// if not consistant with previous ones
                    return false;
            }else{
                if(map.containsValue(c2)) //if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }

        return true;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
    }
}

/*
true
false
 */
