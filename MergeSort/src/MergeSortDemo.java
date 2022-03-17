import java.util.Arrays;

public class MergeSortDemo {

    private MergeSortDemo() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.printf("mergeSort arr[%d %d]%n", l, r);

        //递归终点
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, depth + 1);
        sort(arr, mid + 1, r, depth + 1);
        merge(arr, l, mid, r);
    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    //合并两个有序的区间arr[l, mid]和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);//为什么r+1，是因为该方法 复制的数组是前闭后开的

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];   //现在传过来的arr是从l开始的，因此需要加个偏移值
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

        int n = 100;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        //Integer[] array2 = Arrays.copyOf(array, array.length);
        //Integer[] array3 = Arrays.copyOf(array, array.length);

        SortingHelper.sortTest("MergeSort", array);
        //SortingHelper.sortTest("SelectionSort", array2);
        //SortingHelper.sortTest("InsertionSort", array3);


        //Integer[] reversedArray = ArrayGenerator.generateReversedArray(n);
        //SortingHelper.sortTest("MergeSort", reversedArray);

        //Integer[] arr = {1, 2, 5, 2, 8, 5, 2, 4, 1};
        //SortingHelper.sortTest("MergeSort", arr);
    }
}
