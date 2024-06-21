package com.lt.findCommonHorse;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.03.29 19:51
 */
public class Main {

    private static int iLength;
    private static int jLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        iLength = Integer.parseInt(split[0].trim());
        jLength = Integer.parseInt(split[1].trim());
        Integer[][] move = new Integer[iLength][jLength];
        for (int i = 0; i < iLength; i++){
            String[] split1 = scanner.nextLine().split("");
            for (int j = 0; j < jLength; j++){
                if (Objects.equals(split1[j].trim(), ".")){
                    move[i][j] = 0;
                }else {
                    move[i][j] = Integer.parseInt(split1[j].trim());
                }
            }
        }


        // 通过bfs 统计所有马抵达的位置
        List<Map<String,Integer>> allHorseReach = new ArrayList<>();
        for (int i = 0; i < move.length; i++){
            for (int j = 0; j < move[i].length; j++){
                if (move[i][j] != 0){
                    Map<String, Integer> moveMap = new HashMap<>();
                    allHorseReach.add(moveMap);
                    bfs(i,j,move[i][j],0,moveMap);
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        // 遍历每个位置
        for (int i = 0; i < move.length; i++){
            for (int j = 0; j < move[i].length; j++){
                String key = i + "," + j;
                boolean allReach = true;
                int allCount = 0;
                // 检查每一批马能否抵达该位置
                for (Map<String,Integer> horse : allHorseReach){
                    if (!horse.containsKey(key)){
                        allReach = false;
                        break;
                    }
                    allCount += horse.get(key);
                }
                // 全部马都能抵达
                if (allReach){
                    minCount = Math.min(allCount,minCount);
                }
            }
        }
        System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }

    private static void bfs(int i,int j,int moveAll,int moveCount,Map<String,Integer> moveMap){
        if (i < 0 || i >= iLength || j < 0 || j >= jLength || moveCount > moveAll){
            return;
        }
        // 记录抵达当前位置的步数
        String siteKey = i + "," + j;
        if (!moveMap.containsKey(siteKey)){
            moveMap.put(siteKey, moveCount);
        }else {
            moveMap.put(siteKey, Math.min(moveMap.get(siteKey), moveCount));
        }

        // 能移动的位置
        bfs(i+1, j+2, moveAll, moveCount+1, moveMap);
        bfs(i+1, j-2, moveAll, moveCount+1, moveMap);
        bfs(i-1, j+2, moveAll, moveCount+1, moveMap);
        bfs(i-1, j-2, moveAll, moveCount+1, moveMap);

        bfs(i+2, j+1, moveAll, moveCount+1, moveMap);
        bfs(i+2, j-1, moveAll, moveCount+1, moveMap);
        bfs(i-2, j+1, moveAll, moveCount+1, moveMap);
        bfs(i-2, j-1, moveAll, moveCount+1, moveMap);



    }
}
