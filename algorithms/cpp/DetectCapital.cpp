class Solution {
public:
    bool detectCapitalUse(string word) {
		/**
		 * 统计大写字符的个数count，只有如下三种情况是正确的：
		 * 1. 全是小写，count == 0
		 * 2. 全是大写，count == word.size()
		 * 3. 首字母大写，count == 1, 并且 word[0] 是大写
		 */
        int count = 0;
		for(auto it = word.begin(); it != word.end(); it++)
		{
			if(isupper(*it))
				++count;
		}
        return !count || count == word.size() || (count == 1 && isupper(word[0]));
    }
};