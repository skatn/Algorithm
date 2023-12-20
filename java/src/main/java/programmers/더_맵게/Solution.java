package programmers.더_맵게;

import java.util.NoSuchElementException;

/**
 * 프로그래머스 - 더 맵게 (https://school.programmers.co.kr/learn/courses/30/lessons/42626)
 * 알고리즘 : 최소 힙 (우선 순위 큐)
 */
public class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        MinHeap minHeap = new MinHeap();

        for (int s : scoville) {
            minHeap.add(s);
        }

        while (minHeap.size() > 1 && minHeap.peek() < K) {
            answer++;

            int mix = minHeap.remove() + minHeap.remove() * 2;
            minHeap.add(mix);
        }

        return minHeap.peek() < K ? -1 : answer;
    }

}

class MinHeap {
    private int[] items = new int[1000000];
    private int index = 0;

    public int size() {
        return index;
    }

    public void add(int item) {
        items[index] = item;
        percolateUp(index);
        index++;
    }

    public int remove() {
        if (index == 0) {
            throw new NoSuchElementException();
        }

        int data = items[0];

        items[0] = items[index - 1];
        index--;
        percolateDown(0);

        return data;
    }

    public int peek() {
        return items[0];
    }

    private void percolateUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && items[index] < items[parentIndex]) {
            swap(index, parentIndex);
            percolateUp(parentIndex);
        }
    }

    private void percolateDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < this.index) {
            int min = leftChild;
            if (rightChild < this.index && items[leftChild] > items[rightChild]) {
                min = rightChild;
            }

            if (items[index] > items[min]) {
                swap(index, min);
                percolateDown(min);
            }
        }
    }

    private void swap(int i1, int i2) {
        int temp = items[i1];
        items[i1] = items[i2];
        items[i2] = temp;
    }
}