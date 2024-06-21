package com.lt;

/**
 * @author: Alan
 * @since: 2023/3/23 23:40
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(kmp("abc", "bc"));
    }

    private static int kmp(String str, String pattern) {
        // 获取next数组
        int[] next = getNext(pattern);
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                // 相等时，两指针一起移动
                i++;
                j++;
            } else {
                // 不相等时
                if (j > 0) {
                    // j不用移动到最前面，移动到上一个元素到相同前缀
                    j = next[j - 1];
                } else {
                    // j在最前面了，只移动i
                    i++;
                }
            }
            // j到最后了，直接返回
            if (j == pattern.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int samePreLen = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(samePreLen)) {
                // 最长相同前缀+1
                samePreLen++;
                next[i] = samePreLen;
                i++;
            } else {
                if (samePreLen == 0) {
                    // 没有了最长相同前缀
                    next[i] = 0;
                    i++;
                } else {
                    // 最长相同前缀-1
                    samePreLen = next[samePreLen - 1];
                }
            }
        }
        return next;
    }


}
