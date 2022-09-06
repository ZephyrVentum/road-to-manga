package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(3, 2, 5, 12, 0, 13, 12, 1, 4);
        List<Integer> sortedArray = quickSort(inputArray);
        System.out.println(sortedArray);
    }

    private static List<Integer> quickSort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {
            int current = array.get(0);
            List<Integer> lessArray = new ArrayList<>();
            List<Integer> greaterArray = new ArrayList<>();
            for (int i = 1; i < array.size(); i++) {
                int element = array.get(i);
                if (element <= current) {
                    lessArray.add(element);
                } else {
                    greaterArray.add(element);
                }
            }
            List<Integer> result = new ArrayList<>();
            result.addAll(quickSort(lessArray));
            result.add(current);
            result.addAll(quickSort(greaterArray));
            return result;
        }
    }
}
