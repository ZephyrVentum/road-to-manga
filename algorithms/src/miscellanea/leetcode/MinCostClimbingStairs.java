package miscellanea.leetcode;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }


    public int minCostClimbingStairs(int[] cost) {
        int grandAnswer = 0;
        int greatGrandAnswer = 0;
        int answer = 0;
        for (int current : cost) {
            int answerA = current + grandAnswer;
            int answerB = current + greatGrandAnswer;
            answer = Math.min(answerA, answerB);
            greatGrandAnswer = grandAnswer;
            grandAnswer = answer;
        }
        return Math.min(grandAnswer, greatGrandAnswer);
    }
}
