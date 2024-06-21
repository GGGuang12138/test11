package com.lt.findMoreSuccessRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/banxia_frontend/article/details/134066508
 * @author Alan
 * @Description
 * @date 2024.03.16 22:01
 */
public class Main {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int minAvg = 0;
//        scanner.nextLine();
        String line = "0 0 100 2 2 99 0 2";
        String[] splitNumStr = line.split(" ");
        // 转成int数组
        Integer[] splitNumInt = new Integer[splitNumStr.length];
        for (int i = 0; i < splitNumStr.length; i++) {
             int num = Integer.parseInt(splitNumStr[i].trim());
            splitNumInt[i] = num;
        }

        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<>();
        int currMaxLength = 0;
        int sum = 0;
        while(right < splitNumInt.length){
            int currLength = right - left + 1;
            sum += splitNumInt[right];
            double currAvg = (double) sum / currLength;
            // 平均值满足条件
            if (currAvg <= minAvg) {
                // 长度大于等于当前最大长度进行更新
                if (currLength > currMaxLength) {
                    currMaxLength = currLength;
                    res.clear();
                    res.add(left + "-" + right);
                } else if (currLength == currMaxLength) {
                    res.add(left + "-" + right);
                }
                right ++;
            } else{
                // 平均值不满足条件
                if (left == right){
                    right++;
                }else{
                    sum -= splitNumInt[left];
                    sum -= splitNumInt[right];
                    left++;
                }
            }
        }

        for (String s : res) {
            System.out.print(s + " ");
        }
    }
}
