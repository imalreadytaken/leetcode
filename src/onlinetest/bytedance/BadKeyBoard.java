package onlinetest.bytedance;

import java.util.Scanner;
import java.util.Stack;

public class BadKeyBoard {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        Stack<Character> res = new Stack<>();
        Stack<Integer> lastOp = new Stack<>(); // 0输入，1删除
        Stack<Character> removed = new Stack<>();
        for (char c : in.toCharArray() ) {
            if (c == 'i' ){
                if ( !res.empty()){
                    removed.push(res.pop());
                    lastOp.push(1);
                }
            }else if (c == 'o'){
                if (!lastOp.empty()){
                    int last = lastOp.pop();
                    if (last == 0){
                        res.pop();
                    }else {
                        res.push(removed.pop());
                    }
                }
            }else {
                lastOp.push(0);
                res.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!res.empty()){
            sb.insert(0, res.pop());
        }
        System.out.println(sb.toString());
    }

}
