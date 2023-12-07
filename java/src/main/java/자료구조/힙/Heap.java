package 자료구조.힙;

import java.util.Arrays;
import java.util.Objects;

public class Heap<T extends Comparable<? super T>> {
    private T[] items;
    private int index = 0;
    private final int SIZE = 5;

    public Heap() {
        this.items = (T[]) new Comparable[SIZE];
    }

    public Heap(T[] items) {
        this.items = items;
        this.index = items.length;
        for (int i = index / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public void add(T item) {
        if (items.length == index) {
            T[] newItems = (T[]) new Comparable[items.length + SIZE];
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            this.items = newItems;
        }

        items[index] = item;
        percolateUp(index);
        index++;
    }

    public T deleteMax() {
        T max = items[0];

        index--;
        items[0] = items[index];
        items[index] = null;
        percolateDown(0);

        return max;
    }

    public T max() {
        return items[0];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void clear() {
        items = (T[]) new Comparable[SIZE];
        index = 0;
    }


    private void percolateUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && items[index].compareTo(items[parentIndex]) > 0) {
            swap(index, parentIndex);
            percolateUp(parentIndex);
        }
    }

    private void percolateDown(int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < this.index) {
            int biggerIndex = leftChildIndex;
            if(rightChildIndex < this.index && items[leftChildIndex].compareTo(items[rightChildIndex]) < 0) {
                biggerIndex = rightChildIndex;
            }

            if (items[index].compareTo(items[biggerIndex]) < 0) {
                swap(index, biggerIndex);
                percolateDown(biggerIndex);
            }
        }
    }

    private void swap(int i1, int i2) {
        T temp = items[i1];
        items[i1] = items[i2];
        items[i2] = temp;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(Arrays.stream(items).filter(Objects::nonNull).toArray()) +
                '}';
    }

}
