package com.lt.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2024.03.12 20:27
 */
public class Solution {
    public static void main(String[] args) {
        String input = "ABCDE";
        List<String> permutations = generatePermutations(input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    // 生成给定字符串的所有排列
    public static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper("", input, permutations);
        return permutations;
    }

    // 递归辅助方法，生成给定前缀和剩余字符的所有排列
    private static void generatePermutationsHelper(String prefix, String remaining, List<String> permutations) {
        int n = remaining.length();
        // 如果剩余字符为空，则将当前排列添加到结果列表
        if (n == 0) {
            permutations.add(prefix);
        } else {
            // 否则，对于剩余字符中的每一个字符，递归生成排列
            for (int i = 0; i < n; i++) {
                // 递归调用，将当前字符添加到前缀，剩余字符更新为不包含当前字符的子串
                String remaining1 = remaining.substring(0, i) + remaining.substring(i + 1);
                generatePermutationsHelper(prefix + remaining.charAt(i), remaining1, permutations);
            }
        }
    }
}
