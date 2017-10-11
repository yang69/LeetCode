package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang on 2017/10/9.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]表示，s[0...i-1]能否拆成字典单词的组合
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})) + " <---> true");
    }
}
