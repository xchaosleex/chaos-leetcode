// import java.util.*;

public class Solution {

    public String largestGoodInteger(String num) {
        int len = num.length();
        if (num == null || len < 3) {
            return "";
        }
        int max = -1;
        int charlen = 1;
        char pre = num.charAt(0);
        for (int i = 1; i < len; i++) {
            char curr = num.charAt(i);
            if (curr == pre) {
                charlen++;
            } else {
                charlen = 1;
            }
            if (charlen >= 3) {
                int currint = Integer.valueOf(String.valueOf(curr));
                max = currint > max ? currint : max;
            }
            pre = curr;
        }
        if (max != -1) {
            return max + "" + max + "" + max;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestGoodInteger("6777133339"));
    }

}

