package miscellanea.leetcode;


import java.util.ArrayList;
import java.util.List;

public class MountainBitonicArray {
    interface MountainArray {
        int get(int index);

        int length();
    }

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray() {
            final int[] nums = new int[]{1, 3, 3, 4, 5, 5, 7, 8, 5, 4, 4, 3, 2, 1, 0, 0, 0, 0, 0};

            @Override
            public int get(int index) {
                return nums[index];
            }

            @Override
            public int length() {
                return nums.length;
            }
        };
        //tests
        System.out.println(new MountainBitonicArray().findInMountainArray(3, mountainArray));
    }

    static class SubArrayBounds {
        public SubArrayBounds(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start;
        public int end;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        List<SubArrayBounds> subArrayBounds = new ArrayList<>(2);
        int answer = fillSubArraysWhichContainAnswer(target, mountainArr, 0, mountainArr.length() - 1, -1, subArrayBounds);
        for (SubArrayBounds bounds : subArrayBounds) {
            int temporaryAnswer = binarySearch(mountainArr, target, bounds.start, bounds.end);
            if (answer == -1 || (temporaryAnswer != -1 && temporaryAnswer < answer)) {
                answer = temporaryAnswer;
            }
        }
        return answer;
    }

    public int fillSubArraysWhichContainAnswer(
            int target,
            MountainArray mountainArr,
            int start,
            int end,
            int temporaryAnswer,
            List<SubArrayBounds> subArrayBounds
    ) {
        int mid = (start + end) / 2;
        if (mid - 1 >= 0 && mid + 1 <= mountainArr.length() - 1) {
            int midValue = mountainArr.get(mid);
            int leftValue = mountainArr.get(mid - 1);
            int rightValue = mountainArr.get(mid + 1);
            temporaryAnswer = getTemporaryAnswer(target, mid, midValue, leftValue, rightValue, temporaryAnswer);
            try {
                int direction = getDirectionToThePeak(start, end, midValue, leftValue, rightValue);
                List<SubArrayBounds> newSubArrayBounds = getSubArrays(target, direction, mid, start, end, leftValue, rightValue, temporaryAnswer);
                optimizeSubArrayBounds(subArrayBounds, newSubArrayBounds);
                if (isSubArraysCompleted(direction, subArrayBounds, temporaryAnswer)) {
                    return temporaryAnswer;
                } else {
                    start = direction < 0 ? start : mid + 2;
                    end = direction < 0 ? mid - 2 : end;
                }
            } catch (Exception e) {
                return -1;
            }
        } else {
            return temporaryAnswer;
        }
        return fillSubArraysWhichContainAnswer(target, mountainArr, start, end, temporaryAnswer, subArrayBounds);
    }

    public boolean isSubArraysCompleted(
            int direction,
            List<SubArrayBounds> subArrayBounds,
            int temporaryAnswer
    ) {
        boolean result = false;
        if (direction == 0) {
            result = true;
        } else {
            for (SubArrayBounds bounds : subArrayBounds) {
                if (temporaryAnswer != -1 && temporaryAnswer < bounds.end) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void optimizeSubArrayBounds(
            List<SubArrayBounds> existingSubArrayBounds,
            List<SubArrayBounds> newSubArrayBounds
    ) {
        if (existingSubArrayBounds.isEmpty()) {
            existingSubArrayBounds.addAll(newSubArrayBounds);
        } else {
            for (SubArrayBounds existingBounds : existingSubArrayBounds) {
                for (SubArrayBounds newBounds : newSubArrayBounds) {
                    if (existingBounds.end == newBounds.end && existingBounds.start < newBounds.start) {
                        existingBounds.start = newBounds.start;
                    }
                    if (existingBounds.start == newBounds.start && existingBounds.end > newBounds.end) {
                        existingBounds.end = newBounds.end;
                    }
                }
            }
        }
    }

    public List<SubArrayBounds> getSubArrays(
            int target,
            int direction,
            int mid,
            int start,
            int end,
            int leftValue,
            int rightValue,
            int temporaryAnswer
    ) {
        List<SubArrayBounds> subArrayBounds = new ArrayList<>(2);
        int beforeLeft = mid - 2;
        int afterRight = mid + 2;
        if (direction < 0) {
            if (rightValue > target && (temporaryAnswer == -1 || temporaryAnswer > afterRight)) {
                subArrayBounds.add(new SubArrayBounds(afterRight, end));
            }
            if (temporaryAnswer == -1 || temporaryAnswer > beforeLeft) {
                subArrayBounds.add(new SubArrayBounds(start, beforeLeft));
            }
        } else if (direction > 0) {
            if (leftValue > target && (temporaryAnswer == -1 || temporaryAnswer > beforeLeft)) {
                subArrayBounds.add(new SubArrayBounds(start, beforeLeft));
            }
            if (temporaryAnswer == -1 || temporaryAnswer > afterRight) {
                subArrayBounds.add(new SubArrayBounds(afterRight, end));
            }
        } else if (temporaryAnswer == -1) {
            if (beforeLeft >= 0) {
                subArrayBounds.add(new SubArrayBounds(start, beforeLeft));
            }
            if (afterRight <= end) {
                subArrayBounds.add(new SubArrayBounds(afterRight, end));
            }
        }
        return subArrayBounds;
    }

    public int getTemporaryAnswer(
            int target,
            int mid,
            int midValue,
            int leftValue,
            int rightValue,
            int temporaryAnswer
    ) {
        int newTemporaryAnswer = -1;
        if (target == leftValue) {
            newTemporaryAnswer = mid - 1;
        } else if (target == midValue) {
            newTemporaryAnswer = mid;
        } else if (target == rightValue) {
            newTemporaryAnswer = mid + 1;
        }
        return temporaryAnswer < 0 || temporaryAnswer > newTemporaryAnswer ? newTemporaryAnswer : temporaryAnswer;
    }

    //returns -1 if the peak on the left side, 0 if it is actually the peak, 1 if the peak on the right side.
    public int getDirectionToThePeak(
            int start,
            int end,
            int midValue,
            int leftValue,
            int rightValue
    ) throws Exception {
        int result;
        if (end - start < 3) {
            result = 0;
        } else if (midValue >= leftValue && midValue <= rightValue) {
            result = 1;
        } else if (midValue < leftValue && midValue >= rightValue) {
            result = -1;
        } else if (midValue >= leftValue) {
            result = 0;
        } else {
            throw new Exception("Unhandled exception!");
        }
        return result;
    }

    public int binarySearch(
            MountainArray mountainArray,
            int target,
            int leftBound,
            int rightBound
    ) {
        int mid = (rightBound + leftBound) / 2;
        int number = mountainArray.get(mid);
        if (number == target) {
            return mid;
        } else if (leftBound >= rightBound) {
            return -1;
        } else {
            if (number < target) {
                return binarySearch(mountainArray, target, ++mid, rightBound);
            } else {
                return binarySearch(mountainArray, target, leftBound, --mid);
            }
        }
    }
}
