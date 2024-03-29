package leetcode.findN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.03.28 22:58
 */
public class Main {

    private static String target;
    private static boolean[][] used;

    private static String[][] digits;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();

        digits = new String[length][length];
        used = new boolean[length][length];
        for (int i = 0; i < length; i++){
            String line = scanner.nextLine();
            String[] split = line.split(",");
            for (int j = 0; j < length; j++){
                digits[i][j] = split[j];
            }
        }
        target = scanner.nextLine();


        List<Integer> curr = null;
        boolean success = false;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                curr = new ArrayList<>();
                success = findDigit(i, j, 0, curr);
                if (success){
                    break;
                }
            }
            if (success){
                break;
            }
        }

        if (success){
            StringBuilder sb = new StringBuilder();
            for (int index : curr){
                sb.append(index).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }else {
            System.out.println("N");
        }



    }

    private static boolean findDigit(int i, int j, int targetIndex,List<Integer> curr){
        if (i < 0 && j < 0 || i >= digits.length  || j >= digits.length
                || used[i][j]
                || !digits[i][j].equals(target.substring(targetIndex,targetIndex+1))){
            return false;
        }
        // 添加到结果集合
        used[i][j] = true;
        curr.add(i);
        curr.add(j);
        if (curr.size() == target.length() * 2){
            return true;
        }
        // 遍历四个方向
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] d : direction){
            boolean res = findDigit(i + d[0], j + d[1], targetIndex+1, curr);
            if (res){
                return true;
            }
        }
        // 取消标记
        used[i][j] = false;
        curr.remove(curr.size()-1);
        curr.remove(curr.size()-1);
        return false;
    }
}
