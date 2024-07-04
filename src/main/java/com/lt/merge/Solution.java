package com.lt.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


 提示：

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 * @author Alan
 * @Description
 * @date 2024.07.04 19:35
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.size() == 0) {
                merged.add(interval);
            } else {
                int[] last = merged.get(merged.size() - 1);
                if (interval[0] > last[1]){
                    merged.add(interval);
                }else {
                    // 当前合并到last
                    last[1] = Math.max(last[1], interval[1]);
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
