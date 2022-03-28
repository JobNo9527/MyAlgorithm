/*
    BubbleSort: O(n^2)
 */

public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int i = 0; i + 1 < data.length; i++) {

            //arr[n-i , n) 已排好序
            //通过冒泡在arr[n-i-1] 位置放上合适的元素
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) swap(data, j, j + 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i + 1 < data.length; i++) {

            //arr[n-i , n) 已排好序
            //通过冒泡在arr[n-i-1] 位置放上合适的元素
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }

            if (!isSwapped) break;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = 0; i + 1 < data.length; ) {

            //arr[n-i , n) 已排好序
            //通过冒泡在arr[n-i-1] 位置放上合适的元素
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++)
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }

//            if (lastSwappedIndex == 0) break;
            i = data.length - lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}