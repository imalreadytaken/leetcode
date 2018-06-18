package medium;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        String str = "  +1293 4096789357689 s0dn";
        System.out.println(s.myAtoi(str));
    }

    public int myAtoi(String str) {
        long result = 0;
        int flag = 1;
        boolean first = true;

        for (char c: str.toCharArray()) {
            if (first){
                if (c == ' ') continue;
                else {
                    if (c == '-') {
                        flag = - flag;
                    }
                    else if (c == '+') ;
                    else if ('0' <= c && c <= '9'){
                        result = result * 10 + c - '0';
                    }
                    else{
                        return 0;
                    }
                    first = false;
                }
            }else {
                if ('0' <= c && c <= '9'){
                    result = result * 10 + flag * (c - '0');
                    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                        return result > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }else break;
            }
        }
        return (int) result;
    }

}
