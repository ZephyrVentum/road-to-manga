package miscellanea.other;

import java.util.Arrays;

public class ArraySum {

    public static void main(String[] args) {
        int[] array = {2, 6, 2, 5, 3, 6};//24
        System.out.println(sum(array));
    }

    static int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
        }
    }
}
