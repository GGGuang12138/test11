package leetcode.solve;

/**
 *
 * @author Alan
 * @Description
 * @date 2024.04.29 16:03
 */
public class Solution {

    public static void main(String[] args) {
       solve("2001:0db8:85a3:0: 0:8A2E:0370:7334:");

    }

    public static String solve(String IP) {
        if(isIpv4(IP)){
            return "IPv4";
        }
        if(isIpv6(IP)){
            return "IPv6";
        }
        return "Neither";
    }

    public static boolean isIpv6(String v6){
        String[] v6Group = v6.split(":",-1);
        if (v6Group.length != 8){
            return false;
        }
        for (String s : v6Group){
            if(s.length() > 4 || s.length() == 0 || "0000".equals(s) || "000".equals(s) || "00".equals(s)){
                return false;
            }
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f' ) || (c >= 'A' && c <= 'F');
                if (!expr){
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isIpv4(String v4){
        String[] v4Group = v4.split("\\.");
        if (v4Group.length != 4){
            return false;
        }
        boolean res = true;
        for (String s : v4Group){
            if(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1)){
                res =  false;
                break;
            }
            int num = 0;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (!Character.isDigit(c)){
                    return false;
                }
                num = num * 10 + (c - '0');
            }
            res = num >= 0 && num <= 255;
        }
        return res;

    }

}
