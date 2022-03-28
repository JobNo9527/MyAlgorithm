/*
    从尾巴开始的冒泡排序
 */
public class BubbleSort2 {

    private BubbleSort2() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int i = 0; i + 1 < data.length; i++) {

            //arr[0 , i) 已排好序
            //通过冒泡在 arr[i] 位置放上合适的元素
            for (int j = data.length - 1; j > i; j--)
                if (data[j - 1].compareTo(data[j]) > 0) {
                    swap(data, j - 1, j);
                }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
