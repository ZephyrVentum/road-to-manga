/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        if (k == 0) {
            return;
        }
        while (!StdIn.isEmpty()) {
            if (randomizedQueue.size() == k) {
                randomizedQueue.dequeue();
            }
            String string = StdIn.readString();
            randomizedQueue.enqueue(string);
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
