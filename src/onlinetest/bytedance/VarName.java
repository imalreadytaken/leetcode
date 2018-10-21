package onlinetest.bytedance;

import java.util.Scanner;

public class VarName {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String in = s.nextLine();
            System.out.println(getRes(in));
        }
    }

    public static String getRes(String toHandle){
        int len = toHandle.length();
        if (len < 1) return "";

        StringBuilder sb = new StringBuilder();
        boolean lastIsUpper = true;

        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(toHandle.charAt(i))){
                if (i > 0 && (!lastIsUpper || (i < len - 1 && Character.isLowerCase(toHandle.charAt(i + 1)))) ){
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(toHandle.charAt(i)));
                lastIsUpper = true;
            }else{
                sb.append(toHandle.charAt(i));
                lastIsUpper = false;
            }
        }

        return sb.toString();
    }

}
