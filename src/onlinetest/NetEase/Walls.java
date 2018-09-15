package onlinetest.NetEase;

/**
 * 给定一组数代表一列墙的高度，求这些墙可以存多少水
 * 1,0,1 -> 1
 * 2,0,3 -> 2
 * 6,3,1,0,2 -> 3
 */
public class Walls {

    public int wallsCapacity(int[] walls){
        if (walls.length <= 2) return 0;
        int m = walls.length;
        int[] leftMax = new int[m], rightMax = new int[m];
        leftMax[0] = walls[0];
        rightMax[m - 1] = walls[m - 1];
        for (int i = 1; i < m - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], walls[i]);
            rightMax[ m - 1 - i] = Math.max(rightMax[m - i], walls[m - 1 - i]);
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            res += Math.max(0, Math.min(leftMax[i], rightMax[i]) - walls[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {0,1,0,3,4,1,5,3,6};
        System.out.println(new Walls().wallsCapacity(test));
    }

}
