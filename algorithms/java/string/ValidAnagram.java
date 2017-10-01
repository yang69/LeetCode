package string;

/**
 * Created by Yang on 2017/9/29.
 ************************************************************************************************
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * 变位词（异序词）：438. Find All Anagrams in a String
 ************************************************************************************************
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *  Input:  s = "anagram", t = "nagaram"
 *  Output: true
 *
 * Example 2:
 *  Input:  s = "rat", t = "car"
 *  Output: false
 *
 * Note:
 *      You may assume the string contains only lowercase alphabets.
 * Follow up:
 *      What if the inputs contain unicode characters? How would you adapt your solution to
 *      such case?
 *      --- Use a HashMap
 ************************************************************************************************
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length() ) {
            return false;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        System.out.println(validAnagram.isAnagram("anagram", "nagaram") + " <---> true");
        System.out.println(validAnagram.isAnagram("rat", "car") + " <---> false");
    }
}
