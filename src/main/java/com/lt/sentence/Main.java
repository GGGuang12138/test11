package com.lt.sentence;

import java.util.Scanner;

/**
 * @author Alan
 * @Description
 * @date 2024.04.02 23:09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            sb.append(str).append("\n");
        }
        String content = sb.toString();
        boolean inComment = false;
        boolean inString = false;
        boolean isEmpty = true;
        int count = 0;
        // 遍历
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            char nextChar = i + 1 < content.length() ? content.charAt(i + 1) : ' ';
            if (!inString && c == '-' && nextChar == '-') {
                inComment = true;
                continue;
            }
            if (inComment && c == '\n') {
                inComment = false;
                continue;
            }
            if (!inString && (c == '\"' || c == '\'')) {
                inString = true;
                continue;
            }
            if (!inString && c == ';'){
                if (!isEmpty){
                    count++;
                    isEmpty = true;
                }
                continue;
            }
            if (!inString && !Character.isWhitespace(c)){
                isEmpty = false;
            }
            // 字符串里包含转义符进行跳过
            if (inString && c == '\\') {
                i++;
            }
        }
        if (!isEmpty){
            count++;
        }
        System.out.println(count);

    }
}
