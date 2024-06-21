package com.lt.countRemainChar;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.03.15 20:15
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nextLine = scanner.nextLine();
        String[] split = nextLine.split("@");
        if (split.length == 1){
            System.out.println(split[0]);
        }
        // 解析存在的
        List<String[]> allMapList = new ArrayList<>();
        String[] mapList = split[0].split(",");
        for (int i = 0; i < mapList.length; i++){
            String[] map = mapList[i].split(":");
            allMapList.add(map);
        }
        // 解析已存在的
        Map<String,Integer> existed = new HashMap<>();
        String[] existMapList = split[1].split(",");
        for (int i = 0; i < existMapList.length; i++) {
            String[] existMap = existMapList[i].split(":");
            existed.put(existMap[0], Integer.parseInt(existMap[1]));
        }

        StringBuilder sb = new StringBuilder();
        for (String[] map : allMapList) {
            sb.append(map[0]).append(":");
            if (existed.containsKey(map[0])){
                sb.append(Integer.parseInt(map[1]) - existed.get(map[0]));
            }else {
                sb.append(map[1]);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);



    }
}
