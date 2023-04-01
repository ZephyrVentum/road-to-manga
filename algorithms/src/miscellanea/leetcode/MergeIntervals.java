package miscellanea.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] sample = new int[][]{
//                {0, 0},
//                {2, 6},
//                {1, 3},
//                {7, 11},
//                {11, 11},
                {1, 4},
                {2, 3},
        };
        System.out.println(new MergeIntervals().merge(sample));
    }

    public int[][] merge(int[][] intervals) {
        int[][] answer;
        List<int[]> tempAnswer = new ArrayList<>();
        int[] intervalsLength = new int[10000];
        for (int i = 0; i < intervals.length; i++) {
            int startOfInterval = intervals[i][0];
            int endOfInterval = intervals[i][1];
            intervalsLength[startOfInterval] = Math.max(intervalsLength[startOfInterval], (endOfInterval - startOfInterval) + 1);
        }
        int[] tempInterval = new int[]{-1, -1};
        for (int startOfCurrentInterval = 0; startOfCurrentInterval < intervalsLength.length; startOfCurrentInterval++) {
            int endOfTempInterval = tempInterval[1];
            int currentIntervalLength = intervalsLength[startOfCurrentInterval];
            if (currentIntervalLength != 0) {
                if (endOfTempInterval != -1) {
                    if (startOfCurrentInterval <= endOfTempInterval) {
                        endOfTempInterval = Math.max(endOfTempInterval, startOfCurrentInterval + (intervalsLength[startOfCurrentInterval] - 1));
                        tempInterval[1] = endOfTempInterval;
                    } else {
                        tempAnswer.add(tempInterval);
                        tempInterval = new int[]{
                                startOfCurrentInterval,
                                startOfCurrentInterval + (intervalsLength[startOfCurrentInterval] - 1)
                        };
                    }
                } else {
                    tempInterval[0] = startOfCurrentInterval;
                    tempInterval[1] = startOfCurrentInterval + (intervalsLength[startOfCurrentInterval] - 1);
                }
            }
        }
        int endOfTempInterval = tempInterval[1];
        if (endOfTempInterval != -1) {
            tempAnswer.add(tempInterval);
        }
        answer = new int[tempAnswer.size()][];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        return answer;
    }
}
