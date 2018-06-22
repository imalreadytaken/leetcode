import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {
    /**
     * test
     *
     * @param args stete
     */
    public static void main(String[] args) {
        // jin tian meiyou shijian daka
        List<List<Integer>> mul = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        l.add(0);
        l.add(-1);
        l.add(0);
        l.add(1);
        List<Integer> l2 = new ArrayList<Integer>();
        l.add(0);
        l.add(-1);
        l.add(0);
        l.add(1);
        mul.add(l);

        System.out.println(mul.contains(l2));
    }
}
