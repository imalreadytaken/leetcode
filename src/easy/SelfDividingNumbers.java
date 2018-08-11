package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        String str;
        boolean flag;
        for (int i = left; i <= right; i++) {
            str = i + "";
            flag = true;
            for (char s : str.toCharArray()){
                if ((s == '0') || i % (s - '0') != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(i);
        }
        return res;
    }
}
