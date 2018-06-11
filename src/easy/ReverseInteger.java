package easy;

public class ReverseInteger {

    private long result;
    private int flag;

    public int reverse(int x) {
        flag = x < 0 ? -1 : 1;
        result = 0;
        x = Math.abs(x);
        while (x > 0){
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        result = flag * result;
        if (result > Integer.MAX_VALUE || result <= Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1200));
    }

}
