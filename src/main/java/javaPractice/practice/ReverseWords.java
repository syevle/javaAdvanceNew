package javaPractice.practice;

/**
 *
 * http://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class ReverseWords {
    public static char[] reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);

        return s;
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "the sky is blue";
        System.out.println(reverseWords(s.toCharArray()));
    }
}
