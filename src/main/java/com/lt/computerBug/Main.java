package com.lt.computerBug;

/**
 * @author Alan
 * @Description
 * @date 2024.04.03 12:19
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 电脑的数量
        int connections = sc.nextInt(); // 网络连接的数量
        int[][] times = new int[connections][3]; // 存储每个连接和对应的感染时间
        for (int i = 0; i < connections; i++) {
            times[i][0] = sc.nextInt() - 1; // 感染源电脑编号
            times[i][1] = sc.nextInt() - 1; // 被感染电脑编号
            times[i][2] = sc.nextInt(); // 感染所需时间
        }
        int initial = sc.nextInt() - 1; // 初始被感染的电脑编号，转换为从0开始的索引
        sc.close(); // 关闭输入流

        // 输出感染所有电脑所需的最少时间
        System.out.println(networkDelayTime(times, N, initial));
    }


    // 计算感染所有电脑所需的最少时间的函数
    public static int networkDelayTime(int[][] times, int N, int K) {
        // 初始化所有感染时间为无穷大，源电脑的感染时间为0
        final int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        // 使用Bellman-Ford算法更新所有电脑的最短感染时间
        for (int i = 0; i < N; i++) {
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                // 如果可以通过电脑u感染到电脑v，并且时间更短，则更新电脑v的感染时间
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // 找出所有电脑中最长的感染时间
        int maxWait = 0;
        for (int i = 0; i < N; i++) {
            // 如果有电脑的感染时间仍为无穷大，表示该电脑不可被感染，返回-1
            if (dist[i] == INF) return -1;
            // 更新最长的感染时间
            maxWait = Math.max(maxWait, dist[i]);
        }

        // 返回感染所有电脑所需的最少时间
        return maxWait;
    }
}



