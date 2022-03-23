public class HeapSort {

    private HeapSort() {
    }

    // 非原地排序的
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

    // 原地排序的
    public static <E extends Comparable<E>> void sort2(E[] data) {
        // 所要排序的数组只有一个元素
        if (data.length <= 1)
            return;

        // 起始节点是 data.length-1 的父亲节点，开始将用户传入的数组变成符合最大堆性质的堆，用的方式是heapify的方式
        for (int i = (data.length - 1 - 1) / 2; i >= 0; i--)
            siftDown(data, i, data.length);

        for (int i = data.length - 1; i >= 0; i--) {
            // 与堆顶元素进行交换
            swap(data, 0, i);
            siftDown(data, 0, i);    // 对data[0,n)所形成的最大堆中，索引 k 的元素，执行siftDown
        }
    }

    /**
     * @param data 用户所要siftDown的数组
     * @param k    所要siftDown k对应的元素的值
     * @param n    表示前面的数组是最大堆（改良版堆排序中，用到了原地的排序，原理是数组传进来一整个变成了最大堆，然后此时最左边的元素是最大的，让其放到最右边，
     *             然后除去最后一个（也就是最右边的那个）剩下的数组变成最大堆继续执行上一步操作。
     * @param <E>  支持泛型
     */
    // 对data[0,n)所形成的最大堆中，索引 k 的元素，执行siftDown
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {

        // 因为右孩子的索引比左孩子的索引还要大，如果左孩子的索引(2*k+1)都越界(>n的时候)了，右孩子的索引一定越界，也就是到了k是个叶子节点的时候了
        while (2 * k + 1 < n) {

            int j = 2 * k + 1;
            // 此时j+1就是右孩子
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0)
                j = 2 * k + 1 + 1;  // j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            // 下沉终止条件
            if (data[k].compareTo(data[j]) >= 0)
                break;

            swap(data, k, j);
            k = j;  // k下沉进行下一轮比较
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
