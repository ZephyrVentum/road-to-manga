/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int tail;
    private int size;

    // construct an empty deque
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        tail = 0;
        size = 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                copy[j++] = items[i];
            }
        }
        items = copy;
        tail = j;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (tail == items.length) {
            resize(2 * items.length);
        }
        items[tail++] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[--tail];
        items[tail] = null;
        size--;
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        return items[index];
    }

    public Iterator<Item> iterator() {
        final Item[] iteratorItems = (Item[]) new Object[size];
        for (int i = 0, j = 0; i < items.length; i++) {
            if (items[i] != null) {
                iteratorItems[j++] = items[i];
            }
        }
        StdRandom.shuffle(iteratorItems);

        return new Iterator<Item>() {

            private int pointer = 0;

            public boolean hasNext() {
                return pointer < iteratorItems.length;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (pointer == iteratorItems.length) {
                    throw new NoSuchElementException();
                }
                return iteratorItems[pointer++];
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        queue.enqueue("kek");
        queue.enqueue("kek2");
        queue.enqueue("kek3");
        queue.enqueue("kek4");
        queue.enqueue("kek5");
        StdOut.println(queue.sample());
        for (String string : queue) {
            StdOut.println(string);
        }
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.size());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.isEmpty());
    }
}
