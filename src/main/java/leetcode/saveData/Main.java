package leetcode.saveData;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.04.01 19:22
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        // 读取全部文件
        String[] fileSizeStr = nextLine.split(",");
        List<Integer> fileSizeList = new ArrayList<>();
        for (String s : fileSizeStr) {
            fileSizeList.add(Integer.parseInt(s.trim()));
        }
        Collections.sort(fileSizeList);
        int l = 0;
        int r = fileSizeList.size()-1;
        int count = 0;
        int sum = 0;
        while (l < r){
            sum = fileSizeList.get(l) + fileSizeList.get(r);
            if (sum <= 500){
                fileSizeList.set(r,sum);
                l++;
            }else {
                count++;
                r--;
            }
        }
        if (fileSizeList.get(l) <= 500){
            count++;
        }
        System.out.println(count);

    }
}
