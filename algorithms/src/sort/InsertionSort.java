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
            int key = array.get(i);
            int j = i - 1;
            for (; j >= 0 && array.get(j) > key; j--) {
                array.set(j + 1, array.get(j));
            }
            array.set(j + 1, key);
        }
        return array;
    }
}
