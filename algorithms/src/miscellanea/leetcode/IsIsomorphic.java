package miscellanea.leetcode;

public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("badc", "dede"));
        System.out.println(new IsIsomorphic().isIsomorphic("baba", "badc"));
        System.out.println(new IsIsomorphic().isIsomorphic("paper", "title"));
    }

    public boolean isIsomorphic(String s, String t) {
        char[] mappingS = new char[Character.MAX_VALUE];
        char[] mappingT = new char[Character.MAX_VALUE];
        char defaultChar = mappingT[0];
        for (int i = 0; i < s.length(); i++) {
            char currentCharS = s.charAt(i);
            char currentCharT = t.charAt(i);
            char mappedCharS = mappingS[currentCharS];
            char mappedCharT = mappingT[currentCharT];
            if (mappedCharS == defaultChar && mappedCharT == defaultChar) {
                mappingS[currentCharS] = currentCharT;
                mappingT[currentCharT] = currentCharS;
            } else if (mappedCharS != currentCharT || mappedCharT != currentCharS) {
                return false;
            }
        }
        return true;
    }
}
