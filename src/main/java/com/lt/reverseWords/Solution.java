package com.lt.reverseWords;

import java.util.Arrays;

/**
 * @author Alan
 * @Description
 * @date 2024.06.24 20:17
 */
public class Solution {

    public static void main(String[] args) {
        String s = new Solution().reverseWords(" i  am  ");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        // 先反转String，再反转单词，如果存在空格再向左边移动
        char[] array = s.toCharArray();
        reverse(array,0,s.length()-1);
        reverseWord(array);
        moveWord(array);
        return new String(array);
    }

    public void reverseWord(char[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                continue;
            }
            int left = i;
            while (i < array.length && array[i] != ' ') {
                i++;
            }
            reverse(array, left, i-1);
        }
    }

    public void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public void moveWord(char[] array){
        int fast = 0,slow = 0;
        char lastChar = ' ';
        while (fast < array.length) {
            if (array[fast] == ' ' && lastChar == ' ') {
                fast++;
                continue;
            }
            lastChar = array[fast];
            array[slow++] = array[fast++];
        }
        while (slow < array.length) {
            array[slow++] = ' ';
        }
    }
}
