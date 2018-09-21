package onlinetest.pinduoduo;

import java.util.*;

public class Count {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        String line;
        line = sc.nextLine();
        line = line.toLowerCase();
        line = line.replaceAll("[,!\\-\\?:;.]", " ");
        String[] words = line.split(" ");
        for (String word : words) {
            if (!"".equals(word))
                map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int max = -1;
        Map<Integer, ArrayList<String>> tmp = new HashMap<>();
        for (String word : map.keySet()) {
            int time = map.get(word);
            if (!tmp.containsKey(time)){
                tmp.put(time, new ArrayList());
            }
            tmp.get(time).add(word);
            max = Math.max(time, max);
        }
        ArrayList<String> m = tmp.get(max);
        String[] res = new String[m.size()];
        for (int i = 0; i < m.size(); i++) {
            res[i] = m.get(i);
        }
        Arrays.sort(res);
        String s = String.join(" ",res);
        System.out.println(s);
    }

}
