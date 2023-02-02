package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int searchingNumber = Integer.parseInt(reader.readLine());
        int numberOfIterations = 0;
        final List<Integer> initialArray = new ArrayList<>();
        Integer[] inputData = {10, 23, 30, 23, 54, 21, 321, 64, 22, 166, 11, 31, 634, 233, 121, 45, 112};
        Collections.addAll(initialArray, inputData);
        initialArray.sort(Comparator.comparingInt(o -> o));
        for (int i = 0; i < initialArray.size(); i++) {
            System.out.print(initialArray.get(i) + "(" + i + ")" + " ");
        }
        System.out.println("\nSearching number: " + searchingNumber);
        int position1 = recursiveBinarySearch(initialArray, searchingNumber);
        System.out.println(position1);
    }

    static int recursiveBinarySearch(List<Integer> sortedArray, int searchingNumber) {
        int position = -1;
        if (searchingNumber >= sortedArray.get(sortedArray.size() - 1)) {
            return position;
        }
        int leftBound = 0;
        int rightBound = sortedArray.size() - 1;
        position = search(sortedArray, searchingNumber, leftBound, rightBound);
        return position;
    }

    static int search(List<Integer> sortedArray, int searchingNumber, int leftBound, int rightBound) {
//        System.out.println("L = " + leftBound);
//        System.out.println("R = " + rightBound);
        int position = (rightBound + leftBound) / 2;
        int number = sortedArray.get(position);
        if (number == searchingNumber) {
            return position;
        } else if (leftBound >= rightBound) {
            return -1;
        } else {
            if (number < searchingNumber) {
                return search(sortedArray, searchingNumber, position + 1, rightBound);
            } else {
                return search(sortedArray, searchingNumber, leftBound, position - 1);
            }
        }
    }

    static int loopBinarySearch(List<Integer> sortedArray, int searchingNumber) {
        int position = -1;
        if (searchingNumber >= sortedArray.get(sortedArray.size() - 1)) {
            return position;
        }
        int leftBound = 0;
        int rightBound = sortedArray.size() - 1;
        for (; ; ) {
            System.out.println("L = " + leftBound);
            System.out.println("R = " + rightBound);
            position = (rightBound + leftBound) / 2;
            int number = sortedArray.get(position);
            if (number == searchingNumber) {
                break;
            } else {
                if (number < searchingNumber) {
                    if (leftBound == position) {
                        position = -1;
                        break;
                    }
                    leftBound = position;
                } else {
                    if (rightBound == position) {
                        position = -1;
                        break;
                    }
                    rightBound = position;
                }
            }
        }
        return position;
    }
}
