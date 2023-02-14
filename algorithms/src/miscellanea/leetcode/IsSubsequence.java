package miscellanea.leetcode;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int lastFoundIndex = -1;
        int indexToCompare = 0;
        for (int i = 0; i < t.length(); i++) {
            if (indexToCompare == s.length()) {
                break;
            }
            char currentSymbol = t.charAt(i);
            char subSymbol = s.charAt(indexToCompare);
            if (currentSymbol == subSymbol) {
                indexToCompare++;
            }
        }
        return indexToCompare == s.length();
    }
}
