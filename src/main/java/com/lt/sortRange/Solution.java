package com.lt.sortRange;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alan
 * @Description
 * @date 2024.04.29 17:46
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1,2});
        list.add(new Integer[]{2,3});
        list.add(new Integer[]{4,5});
        list.sort(Comparator.comparingInt(o -> o[0]));
        List<Integer[]> list1 = sortMerge(list);

    }

    public static List<Integer[]> sortMerge(List<Integer[]> list){
        list.sort(Comparator.comparingInt(o -> o[0]));
        if (list.size() < 2){
            return list;
        }
        List<Integer[]> res = new ArrayList<>();
        int rangeL = list.get(0)[0];
        int rangeR = list.get(0)[1];
        for(int i = 1; i < list.size(); i++){
            Integer currL = list.get(i)[0];
            Integer currR = list.get(i)[1];
            if (rangeR < currL){
                // 锁定了区间,添加到结果
                res.add(new Integer[]{rangeL,rangeR});
                rangeL = currL;
                rangeR = currR;
            }else {
                // 更新区间
                rangeR = Math.max(rangeR, currR);
            }
        }
        res.add(new Integer[]{rangeL, rangeR});
        return res;

    }
}
