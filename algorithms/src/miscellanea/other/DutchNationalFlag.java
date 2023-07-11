package miscellanea.other;

import java.util.Arrays;
import java.util.List;

public class DutchNationalFlag {

    static List<Integer> input = Arrays.asList(1, 2, 3, 3, 1, 2, 3, 2, 1);

    public static void main(String[] args) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        int startPointer = 0;
        int endPointer = input.size() - 1;
        for (int i = 1; i <= endPointer; i++) {
            int current = color(i);
            while (current != 2 && startPointer < i && endPointer > i) {
                for (int j : input) {
                    System.out.print(j + " ");
                }
                if (current == 1) {
                    swap(i, startPointer++);
                } else {
                    swap(i, endPointer--);
                }
                current = color(i);
                System.out.println();
                System.out.println(String.format("Current: %s", i));
                System.out.println(String.format("Start: %s", startPointer));
                System.out.println(String.format("End: %s", endPointer));
                for (int j : input) {
                    System.out.print(j + " ");
                }
                System.out.println();
                System.out.println();
            }
            System.out.println();
            System.out.println(String.format("Current!: %s", i));
        }
        System.out.println();
        System.out.println(String.format("N: %s", input.size()));
        System.out.println(String.format("Swaps: %s", swapCounter));
        System.out.println(String.format("Accesses: %s", accessCounter));

        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    static int swapCounter = 0;

    static void swap(int i, int j) {
        swapCounter++;
        int temp = input.get(i);
        input.set(i, input.get(j));
        input.set(j, temp);
    }

    static int accessCounter = 0;

    static int color(int i) {
        accessCounter++;
        return input.get(i);
    }
}
