package com.lt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Alan
 * @since: 2023/3/13 23:02
 */
public class PerfectOperate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // 统计各个字符数量
        Map<Character, Integer> charMap = new HashMap<>(str.length());
        for (Character c : str.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // 确定目标字符及个数
        int avg = str.length() / 4;
        int searchTotal = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            // 数量多于平均值的字符,为目标字符
            if (entry.getValue() > avg) {
                int targetCount = entry.getValue() - avg;
                charMap.put(entry.getKey(), targetCount);
                searchTotal += targetCount;
            }
        }

        // 转化为寻找最短"包含指定个数的字符"的字符串
        int minLength = str.length();
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            // 移动右指针,寻找总数-1,
            char rightC = str.charAt(right);
            if (charMap.get(rightC) > 0) {
                searchTotal--;
            }
            charMap.put(rightC, charMap.get(rightC) - 1);
            // 满足条件,移动左指针
            while (searchTotal == 0) {
                minLength = Math.min(minLength, right - left + 1);
                char leftC = str.charAt(left);
                // 寻找总数+1
                if (charMap.get(leftC) >= 0) {
                    searchTotal++;
                }
                charMap.put(leftC, charMap.get(leftC) + 1);
                left++;
            }
            right++;
        }
        System.out.println(minLength);
    }
}
