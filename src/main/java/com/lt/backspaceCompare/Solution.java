package com.lt.backspaceCompare;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Alan
 * @Description
 * @date 2024.05.27 10:36
 */
public class Solution {

    public boolean backspaceCompare2(String s, String t) {
        int l = s.length() - 1, r = t.length() - 1;
        int skipL = 0, skipR = 0;
        while (l >= 0 || r >= 0){
            // 移动左指针确定可以进行比较的元素
            while (l >= 0) {
                if (s.charAt(l) == '#') {
                    skipL++;
                    l--;
                    continue;
                }
                if (skipL > 0) {
                    skipL--;
                    l--;
                    continue;
                }
                break;
            }
            // 移动右指针确定可以进行
            while (r >= 0) {
                if (t.charAt(r) == '#') {
                    skipR++;
                    r--;
                    continue;
                }
                if (skipR > 0) {
                    skipR--;
                    r--;
                    continue;
                }
                break;
            }
            if (l < 0 && r < 0) {
                return true;
            }
            if (l >= 0 && r >= 0 && s.charAt(l) == t.charAt(r)) {
                l--;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStk = convertToStk(s);
        Stack<Character> tStk = convertToStk(t);
        if (sStk.size() != tStk.size()) {
            return false;
        }
        while (!sStk.isEmpty()) {
            if (!sStk.pop().equals(tStk.pop())) {
                return false;
            }
        }
        return true;
    }

    public Stack<Character> convertToStk(String s){
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stk.push(c);
            } else {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }
        }
        return stk;
    }
}
