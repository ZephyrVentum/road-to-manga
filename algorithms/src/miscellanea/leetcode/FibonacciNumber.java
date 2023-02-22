package miscellanea.leetcode;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib2(5));
    }

    public int fib(int n) {
        int answer;
        if (n == 1) {
            answer = 1;
        } else if (n == 0) {
            answer = 0;
        } else {
            answer = fib(n - 1) + fib(n - 2);
        }
        return answer;
    }

    public int fib2(int n) {
        return (int) ((Math.pow(((1.0 + Math.sqrt(5)) / 2), n) - Math.pow(((1.0 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
    }
}
