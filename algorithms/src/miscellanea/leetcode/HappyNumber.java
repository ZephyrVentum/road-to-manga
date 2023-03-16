package miscellanea.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> arisenNumbers = new HashSet<>();
        boolean flag = true;
        while (flag) {
            int temp = n;
            int expression = 0;
            while (temp != 0) {
                int digit = temp % 10;
                temp /= 10;
                expression += digit * digit;
            }
            if (expression == 1){
                flag = false;
                return true;
            }
            if (arisenNumbers.contains(expression)){
                flag = false;
                return false;
            }
            arisenNumbers.add(expression);
            n = expression;
        }
        return false;
    }
}
