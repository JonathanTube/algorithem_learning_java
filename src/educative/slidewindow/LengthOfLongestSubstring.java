package educative.slidewindow;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int maxLen = 0;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            Integer val = map.get(c);
            if(val == null) {
                map.put(c, i);
            } else {
                if(val >= startIndex) { // 什么时候开始计算最大长度，当遇到之前里面有重复，并且在窗口内
                    maxLen = Math.max(maxLen, i - startIndex); // 计算之前的最大长度
                    startIndex = val + 1; // 重新调整窗口的开始位置
                }
                map.replace(c, i);  // 这里为什么要更新新的下标？如果不更新新的下标，那后面再获取之前出现过的下标时还是之前的
            }
        }
        
        return Math.max(maxLen, s.length() - startIndex);
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}