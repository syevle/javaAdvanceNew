package javaPractice.algo.graph.strings;

/**
 * Check if two given strings are isomorphic to each other

 Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for
 every character of str1 to every character of str2. And all occurrences of every character in ‘str1’ map to same character in ‘str2’

 Examples:

 Input:  str1 = "aab", str2 = "xxy"
 Output: True
 'a' is mapped to 'x' and 'b' is mapped to 'y'.

 Input:  str1 = "aab", str2 = "xyz"
 Output: False
 One occurrence of 'a' in str1 has 'x' in str2 and
 other occurrence of 'a' has 'y'.

 We strongly recommend that you click here and practice it, before moving on to the solution.

 A Simple Solution is to consider every character of ‘str1’ and check if all occurrences of it map to same character in ‘str2’.
 Time complexity of this solution is O(n*n).

 An Efficient Solution can solve this problem in O(n) time. The idea is to create an array to store mappings of processed characters.

 1) If lengths of str1 and str2 are not same, return false.
 2) Do following for every character in str1 and str2
 a) If this character is seen first time in str1,
 then current of str2 must have not appeared before.
 (i) If current character of str2 is seen, return false.
 Mark current character of str2 as visited.
 (ii) Store mapping of current characters.
 b) Else check if previous occurrence of str1[i] mapped
 to same character.

 */
public class Isomorphic {
}
