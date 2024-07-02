package com.lt.findAnagrams;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abba", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * @author Alan
 * @Description
 * @date 2024.06.29 16:46
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        // 统计有效的字母
        Map<Character,Integer> needMap = new HashMap<>();
        for (char c : p.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        // 滑动窗口
        int l = 0, r = 0;
        int currValid = 0;
        Map<Character,Integer> currNumMap = new HashMap<>();
        while (l <= s.length() - p.length()){
            // 右指针移动，使窗口长度达到p的长度
            while(r-l < p.length()){
                char rChar = s.charAt(r);
                if (needMap.containsKey(rChar)){
                    currNumMap.put(rChar,currNumMap.getOrDefault(rChar,0)+1);
                    if (currNumMap.get(rChar).equals(needMap.get(rChar))){
                        currValid++;
                    }
                }
                r++;
            }
            // 有效字母和p的长度相等时，为异位词
            if (currValid == needMap.size()){
                res.add(l);
            }
            // 移动左指针
            char lChar = s.charAt(l);
            if (currNumMap.containsKey(lChar)){
                if (currNumMap.get(lChar).equals(needMap.get(lChar))){
                    currValid--;
                }
                currNumMap.put(lChar,currNumMap.get(lChar)-1);
            }
            l++;

        }
        return res;
    }
}


