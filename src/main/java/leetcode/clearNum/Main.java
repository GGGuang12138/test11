package leetcode.clearNum;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Alan
 * @Description
 * @date 2024.03.28 18:46
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numStr = scanner.nextLine().trim();
        String countStr = scanner.nextLine();
        int cleanCount =  Integer.parseInt(countStr.trim());
        Stack<Integer> stk = new Stack<>();
        // 确保栈是递增的，直到不能再删除数字
        for(int i = 0; i < numStr.length(); i ++){
            char currChar = numStr.charAt(i);
            Integer currNum = Integer.valueOf(currChar + "");
            while (cleanCount > 0 && !stk.isEmpty() && stk.peek() > currNum){
                stk.pop();
                cleanCount --;
            }
            stk.push(currNum);
        }
        // 还需要继续删除数字
        while (cleanCount > 0){
            stk.pop();
            cleanCount --;
        }
        // 拼接成原来的
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (Integer num : stk){
            if (num == 0 && leadingZero){
                continue;
            }
            leadingZero = false;
            sb.append(num);
        }

        System.out.println("".equals(sb.toString()) ? "0" : sb.toString());

    }
}
