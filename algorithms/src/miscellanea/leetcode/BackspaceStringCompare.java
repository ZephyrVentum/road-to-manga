package miscellanea.leetcode;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        char hash = '#';
        int hashCounter = 0;
        //Concatenate both s and t into one long string.
        String st = s + t;
        StringBuilder formatted = new StringBuilder();
        //Move from the end, now it's easier to manage backspacing
        for (int i = st.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1) {
                //Reset counter if one string has passed
                //to prevent backspacing symbols from second string with hashes from the first one
                //e.g. #a#c and a##c
                hashCounter = 0;
            }
            char current = st.charAt(i);
            if (current == hash) {
                hashCounter++;
            } else if (hashCounter > 0) {
                hashCounter--;
            } else {
                formatted.append(current);
            }
        }
        String result = formatted.toString();
        //Answer is true if halves of the result are equal
        String firstHalf = result.substring(0, result.length() / 2);
        String secondHalf = result.substring(result.length() / 2);
        return firstHalf.equals(secondHalf);
    }
}
