package com.lt.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2024.02.23 23:53
 */
public class Solution {
    private List<List<Integer>> res;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        n = n;
        helper(1,k,new ArrayList<>());
        return res;

    }

    public void helper(int start, int k, List<Integer> curr){
        if(k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i <= n; i++){
            curr.add(i);
            helper(i+1,k-1,curr);
            curr.remove(curr.size()-1);
        }
    }
}
