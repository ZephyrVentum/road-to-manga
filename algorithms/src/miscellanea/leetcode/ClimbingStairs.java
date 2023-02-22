package miscellanea.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(4));
    }

    public int climbStairs(int n) {
        int answer = 0;
        if (n == 1) {
            answer = 1;
        } else {
            int greatGrandAnswer = 0;
            int grandAnswer = 1;
            for (int i = 1; i <= n; i++) {
                answer = grandAnswer + greatGrandAnswer;
                greatGrandAnswer = grandAnswer;
                grandAnswer = answer;
            }
        }
        return answer;
    }

    //recursion approach
    public int climbStairsRec(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
