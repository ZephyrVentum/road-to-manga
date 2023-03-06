package miscellanea.leetcode;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
//        System.out.println(Character.digit('5', 10));
    }

    public String decodeString(String s) {
        final char starter = '[';
        final char ender = ']';
        String answer = "";
        Stack<Integer> numbers = new Stack<>();
        Stack<String> encodedStrings = new Stack<>();
        StringBuilder encodedString = new StringBuilder();
        StringBuilder number = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            switch (currentChar) {
                case starter:
                    if (!encodedString.toString().isEmpty()) {
                        encodedStrings.add(encodedString.toString());
                        encodedString = new StringBuilder();
                    }
                    if (!number.toString().isEmpty()) {
                        numbers.add(Integer.parseInt(number.toString()));
                        number = new StringBuilder();
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    number.append(currentChar);
                    break;
                case ender:
                    if (!encodedString.toString().isEmpty()) {
                        encodedStrings.add(encodedString.toString());
                        encodedString = new StringBuilder();
                    }
                    String currentEncodedString = encodedStrings.pop();
                    String decoded = "";
                    int currentTimes = numbers.pop();
                    for (int j = 0; j < currentTimes; j++) {
                        decoded += currentEncodedString;
                    }
                    if (!numbers.isEmpty()) {
                        if (!encodedStrings.isEmpty()) {
                            String top = encodedStrings.pop();
                            decoded = top + decoded;
                        }
                    }else {
                        answer+= decoded;
                    }
                    encodedStrings.add(decoded);
                    break;
                default:
                    encodedString.append(currentChar);
            }
        }
        return (encodedStrings.isEmpty() ? "" : encodedStrings.pop()) + encodedString;
    }
}
