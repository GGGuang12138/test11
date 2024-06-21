package com.lt.ip;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.04.07 23:44
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] groups = s.split(";");

        // 转成map
        Map<String, List<long[]>> cityAndIpListMap = new HashMap<>();
        for (String group : groups){
            String[] cityAndIps = group.split("=");
            // 城市名作为key
            String city = cityAndIps[0];
            cityAndIpListMap.putIfAbsent(city, new ArrayList<>());
            // value为区间的List
            String[] ips = cityAndIps[1].split(",");
            long[] range = new long[2];
            range[0] = toLong(ips[0]);
            range[1] = toLong(ips[1]);
            cityAndIpListMap.get(city).add(range);
        }

        // 遍历每个ip，ip取对应的map进行校验
        StringBuilder sb = new StringBuilder();
        String checkIps = scanner.nextLine();
        String[] ips = checkIps.split(",");
        for (String ip : ips){
            long minRange = Integer.MAX_VALUE;
            String bestCity = "";
            long ipTar = toLong(ip);
            // 检查每个城市的ip访问，判断是否在其中、判断是否为最佳
            for (String city : cityAndIpListMap.keySet()) {
                List<long[]> ranges = cityAndIpListMap.get(city);
                for (long[] range : ranges) {
                    if (ipTar >= range[0] && ipTar <= range[1]) {
                        long rangeSize = range[1] - range[0];
                        if (rangeSize < minRange) {
                            minRange = rangeSize;
                            bestCity = city;
                        }
                    }
                }
            }
            sb.append(bestCity).append(",");
        }
        String res = sb.length() > 0 ? sb.substring(0,sb.length()-1) : "";
        System.out.println(res);


    }

    private static long toLong(String ipStr) {
        String[] split = ipStr.split("\\.");
        long res = 0;
        for (String s : split) {
            res = res * 256 + Integer.parseInt(s);
        }
        return res;
    }
}
