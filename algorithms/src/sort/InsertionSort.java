package sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(3, 2, 5, 12, 0, 13, 12, 1, 4);
        List<Integer> sortedArray = sort(inputArray);
        System.out.println(sortedArray);
    }

    private static List<Integer> sort(List<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            for (int j = i; j > 0 && array.get(j) < array.get(j - 1); j--) {
                int temp = array.get(j -1);
                array.set(j - 1, array.get(j));
                array.set(j, temp);
            }
        }
        return array;
    }
}
