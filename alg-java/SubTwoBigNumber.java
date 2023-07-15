public class SubTwoBigNumber {
    // 使用string做减法
    public String subTwoBigInteger(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (lenA >= 0 || lenB >= 0) {
            int numA = a.charAt(lenA) - '0';
            int numB = 0;
            if (lenB < 0) {
                numB = 0;
            } else {
                numB = b.charAt(lenB) - '0';
            }
            int num = numA - numB - carry;
            if (num < 0) {
                num += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(num);
            lenA--;
            lenB--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        SubTwoBigNumber subTwoBigNumber = new SubTwoBigNumber();
        String a = "10000000000000000000";
        String b = "999";
        System.out.println(subTwoBigNumber.subTwoBigInteger(a, b));
    }

}