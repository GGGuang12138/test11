package leetcode.findContentChildren;

import java.util.Arrays;

/**
 * @author Alan
 * @Description
 * @date 2023.12.17 19:04
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0, res = 0;
        while(i < g.length && j < s.length){
            if(g[i] > s[j]){
                j ++;
            }else{
                res ++;
                i++;
                j++;
            }
        }
        return res;

    }
}
