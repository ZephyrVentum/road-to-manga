package miscellanea.leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        while (flag >= 0) {
            Character anchor = null;
            for (String str : strs) {
                if (flag < str.length()) {
                    char currentChar = str.charAt(flag);
                    if (anchor == null) {
                        anchor = currentChar;
                    } else if (anchor != currentChar) {
                        flag = -1;
                        break;
                    }
                } else {
                    flag = -1;
                    break;
                }
            }
            if (flag >= 0) {
                stringBuilder.append(anchor);
                flag++;
            }
        }
        return stringBuilder.toString();
    }
}
