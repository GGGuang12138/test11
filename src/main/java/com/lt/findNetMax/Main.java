package com.lt.findNetMax;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.03.17 21:17
 */
public class Main {
    private static int count = 0;
    public static int max = 0;
    public static void main(String[] args) {
        // 读取输入转成arr
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int rows = Integer.parseInt(split[0]);
        int columns = Integer.parseInt(split[1]);
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            String s1 = scanner.nextLine();
            String[] split1 = s1.split(" ");
            for (int j = 0; j < columns; j++){
                arr[i][j] = Integer.parseInt(split1[j]);
            }
        }
        // dfs深度遍历
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                count = 0;
                dfs(arr,i,j);
            }
        }
        System.out.println(max);
    }

    public static void dfs(int[][] arr, int i, int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0){
            return;
        }
        // 当前为1，统计+1
        count++;
        max = Math.max(max, count);
        // 修改为0，避免重复计算
        arr[i][j] = 0;
        // 递归检查右边和下边
        dfs(arr, i-1, j);
        dfs(arr, i+1, j);
        dfs(arr, i, j-1);
        dfs(arr, i, j+1);
    }
}
