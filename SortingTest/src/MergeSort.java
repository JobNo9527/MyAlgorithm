import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //合并两个有序的区间(mid+1)
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//为什么r+1，是因为该方法 复制的数组是前闭后开的

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 800000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", array);
    }
}
