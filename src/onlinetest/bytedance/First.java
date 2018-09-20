package onlinetest.bytedance;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.replaceAll("\\.\\./","|");
        s = s.replaceAll("\\./", "");
        s = s.replaceAll("/+", "/");
        while (s.contains("|"))
            s = s.replaceAll("[\\w]+/?\\|", "");
        if (s.length() > 1)
            s = s.replaceAll("/$", "");
        System.out.println(s);
    }

}
