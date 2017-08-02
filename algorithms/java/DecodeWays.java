/**
 * Created by Yang on 2017/8/2.
 *
 * https://leetcode.com/problems/decode-ways/
 ************************************************************************************************
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * Example:
 *  Input: "12"
 *  Output: 2
 *  Explanation:
 *      It could be decoded as "AB" (1 2) or "L" (12).
 ************************************************************************************************
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        dp[s.length()-1] = (s.length() > 0 && s.charAt(s.length()-1) != '0') ? 1 : 0;
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                if (Integer.parseInt(s.substring(i,i+2)) <= 26) {
                    dp[i] = dp[i+1] + dp[i+2];
                } else {
                    dp[i] = dp[i+1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("") + " <---> 0");
        System.out.println(decodeWays.numDecodings("12") + " <---> 2");
    }
}
