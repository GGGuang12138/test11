package leetcode;

/**
 * @author: Alan
 * @since: 2023/3/21 21:54
 */
public class Combination {

    public static void main(String[] args) {
        solve1();
    }

    public static void solve1() {
        for (int i = 1; i <= 26; i++) {
            // 包含i个字母的情况
            backTrack(new StringBuilder(), i, 0);
        }
    }

    public static void backTrack(StringBuilder str, int count, int startIndex) {
        if (count == str.length()) {
            // 达到目标个数
            System.out.println(str.toString());
            return;
        }
        for (int i = startIndex; i < 26; i++) {
            char c = (char) ('a' + i);
            str.append(c);
            backTrack(str, count, i + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }


}
