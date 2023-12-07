package 자료구조.힙;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        System.out.println("heap = " + heap);

        heap = new Heap<>(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println("heap = " + heap);

        Integer max = heap.max();
        System.out.println("max = " + max);
        System.out.println("heap = " + heap);

        Integer maxDelete = heap.deleteMax();
        System.out.println("maxDelete = " + maxDelete);
        System.out.println("heap = " + heap);

        heap.add(3);
        System.out.println("heap add 3");
        System.out.println("heap = " + heap);

        heap.clear();
        System.out.println("heap = " + heap);
    }
}
