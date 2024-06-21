package com.lt;

import java.util.*;

/**
 * @author: Alan
 * @since: 2023/3/25 17:15
 */
public class HotelPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总数量
        int numCount = scanner.nextInt();
        // 挑选数量
        int pickCount = scanner.nextInt();
        // 目标大小
        int target = scanner.nextInt();
        // 读取全部价格和目标值的差
        int[][] allPriceDiff = new int[numCount][2];
        for (int i = 0; i < numCount; i++) {
            allPriceDiff[i][0] = scanner.nextInt();
            allPriceDiff[i][1] = Math.abs(target - allPriceDiff[i][0]);
        }
        // 根据差进行排序
        List<int[]> list = Arrays.asList(allPriceDiff);
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1] == t2[1]) {
                    return Integer.compare(t1[0], t2[0]);
                }
                return Integer.compare(t1[1], t2[1]);
            }
        });
        // 打印结果
        List<Integer> res = new ArrayList<>(pickCount);
        for (int i = 0; i < pickCount; i++) {
            res.add(list.get(i)[0]);
        }
        Collections.sort(res);
        for (Integer v : res) {
            System.out.println(v);
        }


    }
}
