package miscellanea.leetcode;

public class RomanToInt {

    public static void main(String[] args) {
        String s = "III";
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentInt = mapSimpleRomanToInt(currentChar);
            if (i != s.length() - 1) {
                char nextChar = s.charAt(i + 1);
                int nextInt = mapSimpleRomanToInt(nextChar);
                if (currentChar == 'C' && nextChar == 'M'
                        || currentChar == 'C' && nextChar == 'D'
                        || currentChar == 'X' && nextChar == 'L'
                        || currentChar == 'X' && nextChar == 'C'
                        || currentChar == 'I' && nextChar == 'V'
                        || currentChar == 'I' && nextChar == 'X') {
                    currentInt = nextInt - currentInt;
                    i++;
                }
            }
            result += currentInt;
        }
        System.out.println(result);
    }

    public static int mapSimpleRomanToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}