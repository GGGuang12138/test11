package leetcode.ra;

import java.util.*;

/**
 * @author Alan
 * @Description
 * @date 2024.03.26 23:53
 */
public class Main {

    public static int num = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while (scanner.hasNext()){
            String groupNum = scanner.nextLine();
            String[] numStr = groupNum.split(" ");
            Integer[] numsInt = new Integer[numStr.length];
            for (int i = 0; i < numStr.length; i++) {
                numsInt[i] = Integer.parseInt(numStr[i].trim());
            }
            List<Integer> nums = Arrays.asList(numsInt);
            Collections.sort(nums);
            num = 0;
            dfs(0,nums,new ArrayList<>(),new boolean[nums.size()]);
            System.out.println(num);
        }
    }

    /**
     *
     * @param start
     * @param nums
     * @param curr
     * @param all
     * @return 是否可以提前结束
     */
    public static boolean dfs(int start,List<Integer> nums,List<Integer> curr,boolean[] used){
        if (curr.size() == 3){
            int a = nums.get(curr.get(0));
            int b = nums.get(curr.get(1));
            int c = nums.get(curr.get(2));
            double abPowSum = Math.pow(a, 2) + Math.pow(b, 2);
            double cPow = Math.pow(c, 2);
            if (abPowSum == cPow){
                used[curr.get(0)] = true;
                used[curr.get(1)] = true;
                used[curr.get(2)] = true;
                num++;
                return true;
            }
            return cPow > abPowSum;
        }
        for (int i = start; i < nums.size(); i++) {
            if (used[i]){
                continue;
            }
            curr.add(i);
            boolean over = dfs(i + 1, nums, curr,used);
            curr.remove(curr.size()-1);
            if (over){
                break;
            }
        }
        return false;
    }

}
