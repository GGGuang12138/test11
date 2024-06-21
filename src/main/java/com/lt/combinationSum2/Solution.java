package com.lt.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2024.02.24 23:20
 */
public class Solution {
    private List<List<Integer>> res;
    private int[] candidates;
    private int target;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            helper(i,new ArrayList<>(i),i);
        }
        return res;
    }

    public void helper(int currIndex,List<Integer> curr,int sum){
        if(sum == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = currIndex + 1; i < this.candidates.length; i ++){
            curr.add(candidates[i]);
            int addSum = sum+candidates[i];
            System.out.println(curr + " " + addSum);
            helper(i,curr,addSum);
            curr.remove(curr.size()-1);
            helper(i,curr,sum);
        }
    }
}
