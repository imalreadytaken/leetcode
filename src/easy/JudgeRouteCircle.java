package easy;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 * Example 2:
 * Input: "LL"
 * Output: false
 */
public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char move : moves.toCharArray()) {
            switch (move){
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    return false;
            }
        }
        if (x==0 && y==0) return true;
        return false;
    }

}
