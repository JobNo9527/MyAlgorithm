public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data)
            maxHeap.add(e);

        // 从小到大
        for (int i = data.length - 1; i >= 0; i--)
            data[i] = maxHeap.extractMax();

        //// 从大到小
        //for (int i = 0; i < data.length - 1; i++) {
        //    data[i] = maxHeap.extractMax();
        //}
    }
}
