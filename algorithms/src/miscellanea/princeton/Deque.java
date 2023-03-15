/* *****************************************************************************
 *  Name:              Oleksandr Klymenko
 *  Coursera User ID:  f4bfa59164f7dd3a6b9cded066671150
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node<Item> {
        private Node<Item> next;
        private Node<Item> prev;
        private Item val;
    }

    private int size;
    private Node<Item> first, last;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }


    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.val = item;
        size++;

        if (last == null) {
            last = first;
        }
        else if (oldFirst != null) {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node<Item> oldlast = last;
        last = new Node<>();
        last.val = item;
        size++;

        if (first == null) {
            first = last;
        }
        else if (oldlast != null) {
            oldlast.next = last;
            last.prev = oldlast;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.val;

        first = first.next;
        size--;

        if (isEmpty()) {
            last = null;
        }
        else if (first == last) {
            first.next = null;
            first.prev = null;
        }
        else {
            first.prev = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.val;
        last = last.prev;

        size--;

        if (isEmpty()) {
            first = null;
        }
        else if (first == last) {
            first.next = null;
            first.prev = null;
        }
        else {
            last.next = null;
        }

        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Item item = current.val;
                current = current.next;
                return item;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("kek");
        deque.removeFirst();
        deque.addLast("kek338");
        StdOut.println(deque.size());
        String test1 = deque.removeFirst();
        deque.addLast("kek338");
        StdOut.println(test1);
        StdOut.println(deque.size());
        deque.addFirst("kek");
        deque.addFirst("kek2");
        StdOut.println(deque.removeLast());
        deque.addLast("kek8");
        deque.addLast("kek8");
        deque.addLast("kek8");
        deque.addLast("kek8");
        StdOut.println(deque.size());
        for (String string : deque) {
            StdOut.println(string);
        }
        StdOut.println(deque.isEmpty());
    }
}
