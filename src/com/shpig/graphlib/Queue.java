package com.shpig.graphlib;


import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Cody on 3/02/2019.
 *
 * An FILO Queue that uses an array as the underlying container
 */
public class Queue<T> implements Cloneable, java.io.Serializable, Iterable<T>, Collection<T> {
    public static final int DEFAULT_SIZE = 20;


    private Object[] elements;
    //index of first element
    private int start;
    //next index to place an object
    private int end;
    //Number of elements currently in the queue
    private int elementCount;

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int startSize) {
        elements = new Object[startSize];
        start = 0;
        end = 0;
        elementCount = 0;
    }

    /**
     * Removes the oldest element from the queue
     * @return the removed element
     */
    public T remove() {
        if (elementCount == 0) {
            return null;
        } else {
            elementCount--;
            int old = start;
            start = nextIndex(start);
            T oldEl = (T) elements[old];
            elements[old] = null;
            return oldEl;
        }
    }

    /**
     *
     * @param cap
     */
    public void ensureCapacity(int cap) {
        if (cap > elements.length) {
            resize();
        }
    }

    /**
     * Copy all the elements from the queue to the supplied array in order,
     * starting from index 0
     * @param newArray the array to copy to
     */
    private void copyTo(Object[] newArray) {
        if (newArray.length < elementCount)
            throw new RuntimeException("Array to small");

        if (end < start) {
            int firstHalf = elements.length - start;
            System.arraycopy(elements, start, newArray, 0, firstHalf);
            System.arraycopy(elements, 0, newArray, firstHalf, end);
        } else {
            System.arraycopy(elements, start, newArray, 0, end - start);
        }
    }

    /**
     * Double the capacity of the queue
     */
    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        copyTo(newArray);
        elements = newArray;
        end = elementCount;
    }

    /**
     * returns the maximum amount of elements this queue can hold before
     * it needs to resize
     * @return maximum amount of elements this queue can hold
     */
    public int capacity() {
        return elements.length;
    }

    /**
     * Returns the next index in the queue, which is calculated as follows
     * {@code (i + 1) % capacity()}
     * @param i the current index
     * @return the index next index in the queue
     */
    private int nextIndex(int i) {
        return (i + 1) % elements.length;
    }

    /**
     * returns the previous index in the queue
     * @param i the current index
     * @return the previous index in the queue
     */
    private int prevIndex(int i) {
        int ret = i - 1;
        return ret < 0 ? elements.length-1 : ret;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        copyTo(a);
        return a;
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[elementCount]);
    }

    @Override
    public boolean contains(Object o) {
        for (T e : this) {
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T object) {
        elementCount++;
        ensureCapacity(elementCount);
        elements[end] = object;
        end = nextIndex(end);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = start; i != end; i = nextIndex(i)) {
            if (elements[i] != null) {
                elements[i] = null;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = start;

            @Override
            public boolean hasNext() {
                return index+1 != end;
            }

            @Override
            public T next() {
                T ret = (T) elements[index];
                index = nextIndex(index);
                return ret;
            }
        };
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Removes the element at index i and moves everything in front of it
     * back one space, note that if i == end the entire internal array will
     * be moved back one space
     * @param i the index to remove
     */
    private void remove(int i) {
        int next = nextIndex(i);
        int cur = i;
        while (next != end) {
            elements[cur] = elements[next];
            cur = next;
            next = nextIndex(next);
        }
        elementCount--;
        end = cur;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = start; i != end; i = nextIndex(i)) {
            if (elements[i].equals(0)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean ret = false;
        for (Object o : c) {
            ret = remove(o) || ret;
        }
        return ret;
    }

}
