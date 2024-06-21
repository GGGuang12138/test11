package com.lt.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2024.03.08 17:47
 */
public class Solution {

    static List<String> res = new ArrayList<>();
    List<String> letters = List.of("a","b","c","d");

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.helper(0,new StringBuilder());
        System.out.println(res);
    }

    private void helper(int startIndex,StringBuilder curr){
        res.add(curr.toString());
        for(int i = startIndex; i < 4; i++){
            curr.append(letters.get(i));
            helper(i + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
