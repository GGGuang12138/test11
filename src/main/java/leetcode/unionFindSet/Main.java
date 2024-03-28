package leetcode.unionFindSet;

/**
 * @author Alan
 * @Description
 * @date 2024.03.28 18:08
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class UnionFindSet {
        private int[] father; // 存储每个节点的父节点

        public UnionFindSet(int n) { // 初始化并查集，每个节点的父节点为自己
            father = new int[n];
            for (int i = 0; i < n; i++) father[i] = i;
        }

        public int find(int x) { // 查找x的祖先节点，路径压缩优化
            if (father[x] != x) {
                father[x] = find(father[x]);
            }
            return father[x];
        }

        public void unionSet(int x, int y) { // 合并x和y所在的集合
            int x_fa = find(x);
            int y_fa = find(y);

            if (x_fa != y_fa) { // 如果x和y不在同一个集合中，则将y的祖先节点设为x的祖先节点
                father[y_fa] = x_fa;
            }
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] relations = new int[n - 1][2]; // 存储n-1条关系
        for (int i = 0; i < n - 1; i++) { // 输入n-1条关系
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        int min_dp = Integer.MAX_VALUE; // 最小的最大连通块大小
        List<Integer> city = new ArrayList<>(); // 最小的最大连通块所在的城市

        for (int i = 1; i <= n; i++) { // 枚举每个城市作为特殊城市
            UnionFindSet ufs = new UnionFindSet(n + 1); // 初始化并查集
            for (int[] relation : relations) { // 将与特殊城市相连的边删除
                int x = relation[0], y = relation[1];
                if (x == i || y == i) continue;
                ufs.unionSet(x, y);
            }

            Map<Integer, Integer> count = new HashMap<>(); // 统计每个连通块的大小
            for (int f : ufs.father) {
                f = ufs.find(f);
                count.put(f, count.getOrDefault(f, 0) + 1);
            }

            int dp = 0; // 最大连通块大小
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                dp = Math.max(dp, entry.getValue());
            }

            if (dp < min_dp) { // 如果当前最大连通块大小比之前的最小值还小，则更新最小值和最小值所在的城市
                min_dp = dp;
                city.clear();
                city.add(i);
            }
            else if (dp == min_dp) { // 如果当前最大连通块大小与之前的最小值相等，则将城市加入最小值所在的城市列表
                city.add(i);
            }
        }

        for (int c : city) { // 输出最小的最大连通块所在的城市
            System.out.print(c + " ");
        }
    }
}
