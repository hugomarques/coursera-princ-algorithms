import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports adding
 * and removing items from either the front or the back of the data structure.
 * @author hugomarques
 * @since 2/6/17.
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     *
     */
    private Node<Item> head;

    /**
     *
     */
    private Node<Item> tail;

    /**
     *
     */
    private int size;

    private static class Node<Item> {

        /**
         *
         */
        private Node<Item> previous;

        /**
         *
         */
        private Item item;

        /**
         *
         */
        private Node<Item> next;
    }

    /**
     * Construct an empty deque.
     */
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Is the deque empty?
     * @return true if size == 0;
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Return the number of items on the deque.
     * @return n>=0.
     */
    public int size() {
        return this.size;
    }

    /**
     * Add the item to the front.
     * @param item item to be added.
     */
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        final Node<Item> oldHead = head;
        this.head = new Node<>();
        this.head.previous = null;
        this.head.item = item;
        this.head.next = oldHead;
        if (this.isEmpty()) tail = this.head;
        this.size++;
    }

    /**
     * Add the item to the end.
     * @param item item to be added.
     */
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        final Node<Item> oldTail = tail;
        this.tail = new Node<>();
        this.tail.previous = oldTail;
        this.tail.item = item;
        this.tail.next = null;
        if (this.isEmpty()) {
            this.head = this.tail;
        } else {
            oldTail.next = this.tail;
        }
        this.size++;
    }

    /**
     * Remove and return the item from the front.
     * @return removed item.
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        final Node<Item> oldHead = head;
        this.head = head.next;
        if (this.head != null) this.head.previous = null;
        else this.tail = this.head;
        size--;
        return oldHead.item;
    }

    /**
     * Remove and return the item from the end.
     * @return removed item.
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        final Node<Item> oldTail = tail;
        this.tail = tail.previous;
        if (this.tail != null) this.tail.next = null;
        else this.tail = this.head;
        size--;
        return oldTail.item;
    }

    /**
     * Return an iterator over items in order from front to end.
     * @return See
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
