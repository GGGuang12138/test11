package com.lt.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alan
 * @Description
 * @date 2023.08.20 21:31
 */
public class Solution {

    public int  lengthOfLongestSubstring(String s) {
        Set<Character> curr = new HashSet<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < s.length()){
            Character charC = s.charAt(r);
            // 当前已经存在重复字符串，先移动左指针将其移除
            while(curr.contains(charC) && l <= r){
                curr.remove(s.charAt(l));
                l++;
            }
            curr.add(charC);
            res = Math.max(res,r-l+1);
            r ++;
        }
        return res;
    }
}
