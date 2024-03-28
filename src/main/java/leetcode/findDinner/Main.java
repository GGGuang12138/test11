package leetcode.findDinner;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.03.27 23:48
 */
public class Main {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // 读取数据
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int iLength = Integer.parseInt(split[0].trim());
        int jLength = Integer.parseInt(split[1].trim());
        int[][] local = new int[iLength][jLength];
        // 转成int[][]
        for (int i = 0; i < iLength; i++){
            line = scanner.nextLine();
            split = line.split(" ");
            for (int j = 0; j < jLength; j++){
                local[i][j] = Integer.parseInt(split[j].trim());
            }
        }
        // 以2为起点，dfs找到能抵达的餐厅
        int peopleCount = 0;
        for(int i = 0; i < local.length; i++){
            for (int j = 0; j < local[i].length; j++){
                if(local[i][j] == 2){
                    peopleCount ++;
                    findDinner(local,i,j,new boolean[local.length][local[0].length]);
                }
            }
        }
        int res = 0;
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            Integer reachCount = map.get(key);
            if (peopleCount == reachCount){
                res ++;
            }
        }
        System.out.println(res);

    }

    public static void findDinner(int[][] local,int i, int j,boolean[][] used) {
        used[i][j] = true;
        for (int k = 0; k < used.length; k++){
            System.out.println(Arrays.toString(used[k]));
        }
        System.out.println();
        // 当前为墙壁
        if (local[i][j] == 1) {
            return;
        }
        // 记录抵达餐厅的节点数
        if (local[i][j] == 3) {
            String dinnerKey = i + "_" + j;
            if(map.containsKey(dinnerKey)){
                map.put(dinnerKey, map.get(dinnerKey) + 1);
            }else {
                map.put(dinnerKey,1);
            }
        }
        if (i > 0 && !used[i - 1][j]){
            findDinner(local, i - 1, j,used);
        }
        if (j > 0 && !used[i][j - 1]){
            findDinner(local, i, j - 1, used);
        }

        if (i < local.length-1 && !used[i + 1][j]){
            findDinner(local, i + 1, j, used);
        }
        if (j < local[0].length-1 && !used[i][j + 1]){
            findDinner(local, i, j + 1, used);
        }

    }


}
