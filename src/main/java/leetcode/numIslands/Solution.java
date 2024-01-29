package leetcode.numIslands;

/**
 * @author Alan
 * @Description
 * @date 2024.01.30 00:04
 */
public class Solution {

    // 遍历二维数组，等于1时进行统计，同时用dfs算法把同一个岛屿的位置修改为0，避免重复统计
    char[][] g;
    public int numIslands(char[][] grid) {
        int sum = 0;
        g = grid;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    sink(i,j);
                    sum ++;
                }
            }
        }
        return sum;
    }

    public void sink(int i, int j){
        if(i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == '0') return;
        g[i][j] = '0';
        sink(i + 1, j);
        sink(i, j + 1);
        sink(i - 1, j);
        sink(i, j - 1);
    }
}
