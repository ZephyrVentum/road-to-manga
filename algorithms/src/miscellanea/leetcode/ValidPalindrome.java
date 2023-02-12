package miscellanea.leetcode;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "ab_a";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }


    public boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[\\W_]", "");
        StringBuilder stringBuilder = new StringBuilder();
        for (char symbol : cleaned.toCharArray()){
            stringBuilder.insert(0,symbol);
        }
        String reversed = stringBuilder.toString();
        return cleaned.equals(reversed);
    }
}
