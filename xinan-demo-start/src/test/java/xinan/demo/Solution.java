package xinan.demo;

import java.util.*;

/**
 * @description:
 * @author: xinan
 * @create: 2021-07-10 14:11
 **/



public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsValue(chars[i])) {
                length = i - map.get(chars[i]);
            } else {
                length++;
            }

            max = Math.max(max, length);
        }
        return max;
    }
}
