package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Alan
 * @since: 2023/3/23 17:11
 */
public class Main {

    public static void main(String[] args) {

        String text = "我要听黄家驹的海阔天空";
        String[] words = new String[]{"海阔天空黄家驹"};
        for (String word : words) {
            if (word.length() < 3) {
                continue;
            }
            // 截取成最小匹配单位(三个字符)
            List<String> subStrs = new ArrayList<>();
            for (int i = 0; i <= word.length() - 3; i++) {
                subStrs.add(word.substring(i, i + 3));
            }
            int minIndex = word.length();
            int maxIndex = 0;
            for (String subStr : subStrs) {
                if (!text.contains(subStr)) {
                    continue;
                }
                int beginIndex = text.indexOf(subStr);
                minIndex = Math.min(beginIndex, minIndex);
                maxIndex = Math.max(maxIndex, beginIndex);
            }
            // 截取前后缀
            String prefix = text.substring(0, minIndex);
            String suffix = text.substring(maxIndex + 3);
            System.out.println("prefix:" + prefix);
            System.out.println("suffix:" + suffix);
        }

    }
}
