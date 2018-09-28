package onlinetest.NetEase;

import java.util.*;

public class AlphaCards {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String nk = s.nextLine().trim();
        int n = Integer.valueOf(nk.split(" ", 2)[0]);
        int k = Integer.valueOf(nk.split(" ", 2)[1]);
        String cards = s.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cards.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Character[] res = map.keySet().toArray(new Character[map.keySet().size()]);
        Arrays.sort(res, (Character o1, Character o2)-> {
            int i1 = map.get(o1);
            int i2 = map.get(o2);
            if (i1 > i2) return -1;
            else if (i1 == i2) return 0;
            else return 1;
        });
        int get = 0, score = 0;
        for (Character c: res) {
            if (get >= k) break;
            int cnt = Math.min(map.get(c), k - get);
            score += cnt * cnt;
            get += cnt;
        }
        System.out.println(score);
    }

}
