package miscellanea.leetcode;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[l3[e4[c5[t]]]]"));
//        System.out.println(new DecodeString().decodeString("sd2[f2[e]g]i"));
//        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
//        System.out.println(Character.digit('5', 10));
    }

    public String decodeString(String s) {
        final char starter = '[';
        final char ender = ']';
        Stack<Integer> numbersStack = new Stack<>();
        Stack<String> encodedStack = new Stack<>();
        StringBuilder encodedBuilder = new StringBuilder();
        StringBuilder numberBuilder = new StringBuilder();
        StringBuilder answerBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            switch (currentChar) {
                case starter:
                    String encodedString = encodedBuilder.toString();
                    if (!encodedString.isEmpty()) {
                        if (!numbersStack.isEmpty()) {
                            if (numbersStack.size() > encodedStack.size()) {
                                encodedStack.add(encodedString);
                            } else if (!encodedStack.isEmpty()) {
                                String topEncodedString = encodedStack.pop();
                                encodedString = topEncodedString + encodedString;
                                encodedStack.add(encodedString);
                            }
                        } else {
                            answerBuilder.append(encodedString);
                        }
                        encodedBuilder = new StringBuilder();
                    }
                    String number = numberBuilder.toString();
                    if (!number.isEmpty()) {
                        numbersStack.add(Integer.parseInt(number));
                        numberBuilder = new StringBuilder();
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
                    numberBuilder.append(currentChar);
                    break;
                case ender:
                    String notCompetedEncodedString = encodedBuilder.toString();
                    if (!notCompetedEncodedString.isEmpty()) {
                        if (numbersStack.size() > encodedStack.size()) {
                            encodedStack.add(notCompetedEncodedString);
                        } else if (!encodedStack.isEmpty()) {
                            String topEncodedString = encodedStack.pop();
                            notCompetedEncodedString = topEncodedString + notCompetedEncodedString;
                            encodedStack.add(notCompetedEncodedString);
                        }
                        encodedBuilder = new StringBuilder();
                    }
                    String currentEncodedString = encodedStack.pop();
                    StringBuilder decoded = new StringBuilder();
                    int currentNumber = numbersStack.pop();
                    for (int j = 0; j < currentNumber; j++) {
                        decoded.append(currentEncodedString);
                    }
                    if (!numbersStack.isEmpty()) {
                        if (numbersStack.size() > encodedStack.size()) {
                            encodedStack.add(decoded.toString());
                        } else if (!encodedStack.isEmpty()) {
                            String topEncodedString = encodedStack.pop();
                            decoded.insert(0, topEncodedString);
                            encodedStack.add(decoded.toString());
                        }
                    } else {
                        answerBuilder.append(decoded);
                    }
                    break;
                default:
                    encodedBuilder.append(currentChar);
            }
        }
        return answerBuilder.toString() + (encodedStack.isEmpty() ? "" : encodedStack.pop()) + encodedBuilder.toString();
    }
}
