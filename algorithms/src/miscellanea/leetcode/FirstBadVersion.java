package miscellanea.leetcode;

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }

    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public int firstBadVersion(int n) {
        int answer;
        if (n == 1) {
            answer = 1;
        } else {
            answer = searchB(1, n);
        }
        return answer;
    }

    int searchB(long leftBound, long rightBound) {
        int position = (int) (leftBound > rightBound ? leftBound : (rightBound + leftBound) / 2);
        boolean isBadVersion = isBadVersion(position);
        if (leftBound >= rightBound && isBadVersion) {
            return position;
        } else if (isBadVersion) {
            return searchB(leftBound, position - 1);
        } else {
            return searchB(position + 1, rightBound);
        }
    }
}
