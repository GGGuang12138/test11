package com.lt.lengthOfLongestSubstring2;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * @author Alan
 * @Description
 * @date 2024.07.02 14:21
 */
public class Solution {

    public static void main(String[] args) {

        String str = "";

    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            char rChar = s.charAt(r);
            // 移动左指针
            while (set.contains(rChar)){
                set.remove(s.charAt(l));
                l++;
            }
            // 移动右指针
            set.add(rChar);
            r++;
            // 更新最长子串
            res = Math.max(res, r - l);

        }
        return res == Integer.MIN_VALUE? 0 : res;
    }

}