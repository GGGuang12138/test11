package com.lt.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Alan
 * @since: 2023/3/16 23:43
 */
public class Split {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(split("", "&&")));
    }

    public static String[] split(String str, String target) {
        List<String> res = new ArrayList<>(str.length());
        while (str.length() > 0) {
            // 查找目标截取字符
            int i = str.indexOf(target);
            if (i == -1) {
                res.add(str);
                break;
            }
            // 截取子串放入结果
            String subStr = str.substring(0, i);
            res.add(subStr);
            // 剩下的继续截取
            str = str.substring(i + target.length());
        }

        return res.toArray(new String[res.size()]);
    }
}
