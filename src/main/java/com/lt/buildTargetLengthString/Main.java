package com.lt.buildTargetLengthString;

import java.util.*;

/**
 * https://blog.csdn.net/banxia_frontend/article/details/134450378
 * @author Alan
 * @Description
 * @date 2024.03.12 19:51
 */
public class Main {

    private static Set<String> set = new HashSet<>();
    private static List<String> list = new ArrayList<>();

    private static Integer length;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] in = s.split(" ");
        String str = in[0];
        length = Integer.parseInt(in[1].trim());
        helper3(str,"",new boolean[str.length()]);
        System.out.println(list.size());
    }

    private static void helper(String str,String curr,boolean[] used){
        if (curr.length() == length){
            set.add(curr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]){
                continue;
            }
            if (curr.length() > 0 && str.charAt(i) == curr.charAt(curr.length() - 1)) {
                continue;
            }
            used[i] = true;
            helper(str, curr+str.charAt(i), used);
            used[i] = false;
        }
    }

    private static void helper2(String str,StringBuilder curr,boolean[] used){
        if (curr.length() == length){
            set.add(curr.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
                if (used[i]){
                continue;
            }
            if (i > 0 && str.charAt(i) == str.charAt(i-1) && used[i - 1]) {
                continue;
            }
            if (curr.length() > 0 && str.charAt(i) == curr.charAt(curr.length() - 1)) {
                continue;
            }
            used[i] = true;
            helper2(str, curr.append(str.charAt(i)), used);
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);

        }
    }

    private static void helper3(String str,String curr,boolean[] used){
        if (curr.length() == length){
            list.add(curr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i]){
                continue;
            }
            if (i > 0 && str.charAt(i) == str.charAt(i-1)) {
                continue;
            }
            if (curr.length() > 0 && str.charAt(i) == curr.charAt(curr.length() - 1)) {
                continue;
            }
            used[i] = true;
            helper3(str, curr+str.charAt(i), used);
            used[i] = false;
        }
    }
}
