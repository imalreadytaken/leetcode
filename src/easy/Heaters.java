package easy;

import java.util.Arrays;

/**
 * 1、房子和暖气都排序。适用于暖气房子个数差不多的情况
 * 2、只排暖气，然后用二分查找遍历房子。适用于暖气较少，房子较多的情况。
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 *
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int small = 0, big = 0, heaterCnt = heaters.length, max = 0;
        for (int i = 0; i < houses.length;) {
            if (houses[i] > heaters[big] && big < heaters.length - 1) small = big++;
            else{
                max = Math.max(max, Math.min(Math.abs(houses[i] - heaters[small]), Math.abs(houses[i] - heaters[big])));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,10};
        int[] heaters = {2,8,5};
        System.out.println(new Heaters().findRadius(houses, heaters));
    }

}
