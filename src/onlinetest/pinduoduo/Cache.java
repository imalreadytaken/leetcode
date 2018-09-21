package onlinetest.pinduoduo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cache {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int times = sc.nextInt();
        int[] seq = new int[times];

        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < times; i++) {
            seq[i] = sc.nextInt();
            if (!first.containsKey(seq[i]))
                first.put(seq[i], i);
            last.put(seq[i], i);
        }

        int size = 1;

        while (true){
            int[] cache = new int[size];
            for (int i = 0; i < size; i++) {
                cache[i] = -1;
            }
            boolean yes = true;
            for (int i = 0; i < times; i++) {
                int dest = seq[i] % size;
                if (cache[dest] == seq[i])
                    continue;
                if (cache[dest] == -1 || last.get(cache[dest]) < i)
                    cache[dest] = seq[i];
                else {
                    yes = false;
                    break;
                }
            }
            if (yes){
                System.out.println(size);
                return;
            }
            size++;
        }



    }

}
