package leetcode;

/**
 * @author: Alan
 * @since: 2023/4/17 21:44
 */
public class Binary {


    public static void main(String[] args) {
        hammingWeight(-3);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }
}
