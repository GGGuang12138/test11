package com.lt;

import java.util.Scanner;

/**
 * @author: Alan
 * @since: 2023/3/12 22:18
 */
public class Exclude101 {

    /**
     * 遍历
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int leftNum = in.nextInt();
        int rightNum = in.nextInt();
        int count = 0;
        for (int i = leftNum; i <= rightNum; i++) {
            String binaryString = Integer.toBinaryString(i);
            if (!binaryString.contains("101")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
